package by.epam.task3.model;

import by.epam.task3.exception.InvalidCargoException;
import by.epam.task3.exception.PierUnavailableException;
import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Instances of this class represent a single ship acting in it's personal thread.
 */
public class Ship implements Runnable {
    private static final Logger LOGGER = Logger.getLogger("Ship");
    private static int amountOfShips;
    private final int shipNumber;
    private final int MAX_CAPACITY = 10;
    private int cargo;
    private Harbor harbor;

    public Ship(Harbor harbor, int cargo) {
        this.harbor = harbor;
        this.cargo = cargo;
        this.shipNumber = ++amountOfShips;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int newCargo) throws InvalidCargoException {
        if (newCargo > MAX_CAPACITY || newCargo < 0) {
            throw new InvalidCargoException("Invalid cargo");
        }
        int difference = newCargo - cargo;
        if (difference > 0) {
            LOGGER.info("Ship № " + shipNumber + " was loaded with " + difference + " tons");
        } else {
            LOGGER.info("From the ship № " + shipNumber + " was unloaded " + -difference + " tons");
        }
        cargo = newCargo;
    }

    @Override
    public void run() {
        Pier pier = null;
        Random random = new Random();
        try {
            pier = harbor.letMoor();
            LOGGER.info("Ship № " + shipNumber + " moored");
            pier.unloadShip(this, random.nextInt(8) + 1);
            pier.loadShip(this, random.nextInt(5) + 1);
        } catch (PierUnavailableException e) {
            LOGGER.error("Ship № " + shipNumber + " left harbor without service");
        } catch (InvalidCargoException e) {
            LOGGER.error("Failed to load ship № " + shipNumber);
        } finally {
            if (pier != null) {
                harbor.letDepart(pier);
                LOGGER.info("Ship № " + shipNumber + " departed");
            }
        }
    }
}
