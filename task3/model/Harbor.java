package by.epam.task3.model;

import by.epam.task3.exception.InvalidCargoException;
import by.epam.task3.exception.PierUnavailableException;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * This enum contains the only object - harbor, which supposed to have shared resource - {@link Pier piers}.
 * To make a new harbor there is a nested class {@link ListPreparator ListPreparator}.
 */
public enum Harbor {
    HARBOR(new Harbor.ListPreparator().prepareList(getAmountOfPiers()));

    private static final Logger LOGGER = Logger.getLogger(Harbor.class.getName());
    private static final String WAREHOUSE_ERR_MSG = "Warehouse is overloaded";
    private static final int AMOUNT_OF_PIERS = 7;
    private static final int WAREHOUSE_CAPACITY = 250;
    private static final int ABLE_FOR_WAITING = 10;
    private final Queue<Pier> PIERS = new LinkedList<>();
    private final Semaphore SEMAPHORE = new Semaphore(AMOUNT_OF_PIERS, true);
    private int capacity;

    Harbor(List<Pier> piers) {
        this.PIERS.addAll(piers);
    }

    public static int getAmountOfPiers() {
        return AMOUNT_OF_PIERS;
    }

    /**
     * This method allows to control amount of available piers.
     * If they absence it throws exception.
     *
     * @return available pier
     * @throws PierUnavailableException if there is no available piers
     */
    public synchronized Pier letMoor() throws PierUnavailableException {
        try {
            if (SEMAPHORE.tryAcquire(ABLE_FOR_WAITING, TimeUnit.MICROSECONDS)) {
                return PIERS.peek();
            }
        } catch (InterruptedException e) {
            throw new PierUnavailableException();
        }
        throw new PierUnavailableException();
    }

    /**
     * This method is for receiving back piers once given by harbor.
     *
     * @param pier pier to return
     */
    public void letDepart(Pier pier) {
        try {
            loadWarehouse(pier.getCurrentCargo());
        } catch (InvalidCargoException e) {
            LOGGER.error(WAREHOUSE_ERR_MSG);
        }
        PIERS.add(pier);
        SEMAPHORE.release();
    }

    /**
     * This method transfers cargo to warehouse.
     *
     * @param cargo weight of cargo for transferring
     * @throws InvalidCargoException if there is no empty space for more cargo
     */
    private void loadWarehouse(int cargo) throws InvalidCargoException {
        if (capacity + cargo < WAREHOUSE_CAPACITY) {
            capacity += cargo;
            LOGGER.info("Warehouse was loaded with " + cargo
                    + ". It contains " + capacity + " tons now");
        } else {
            throw new InvalidCargoException(WAREHOUSE_ERR_MSG);
        }
    }

    private static class ListPreparator {

        List<Pier> prepareList(int amountOfPiers) {
            LinkedList<Pier> piers = new LinkedList<>();
            for (int i = 0; i < amountOfPiers; i++) {
                piers.add(new Pier());
            }
            return piers;
        }
    }
}
