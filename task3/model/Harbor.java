package by.epam.task3.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import by.epam.task3.exception.InvalidCargoException;
import by.epam.task3.exception.PierUnavailableException;
import by.epam.task3.util.ListPreparator;
import org.apache.log4j.Logger;

public enum Harbor {
    HARBOR(new ListPreparator().prepareList(7));

    private static final int AMOUNT_OF_PIERS = 7;
    private static final int WAREHOUSE_CAPACITY = 200;
    private static final int ABLE_FOR_WAITING = 1;
    private static final Logger LOGGER = Logger.getLogger(Harbor.class.getName());
    private final ConcurrentLinkedQueue<Pier> PIERS = new ConcurrentLinkedQueue<>();
    private final Semaphore SEMAPHORE = new Semaphore(AMOUNT_OF_PIERS, true);
    private static int capacity;

    Harbor(List<Pier> piers) {
        this.PIERS.addAll(piers);
    }

    public Pier letMoor() throws PierUnavailableException {
        try {
            if (SEMAPHORE.tryAcquire(ABLE_FOR_WAITING, TimeUnit.MICROSECONDS)) {
                return PIERS.poll();
            }
        } catch (InterruptedException e) {
            throw new PierUnavailableException();
        }
        throw new PierUnavailableException();
    }

    public void letDepart(Pier pier) {
        try {
            loadWarehouse(pier.getCurrentCargo());
        } catch (InvalidCargoException e) {
            LOGGER.error("Warehouse is overloaded");
        }
        PIERS.add(pier);
        SEMAPHORE.release();
    }


    private void loadWarehouse(int cargo) throws InvalidCargoException {
        if (capacity + cargo < WAREHOUSE_CAPACITY) {
            capacity += cargo;
            LOGGER.info("Warehouse loaded for " + cargo
                    + ". It contains " + capacity + " tons now");
        } else {
            throw new InvalidCargoException("Warehouse overloaded");
        }
    }


}
