package by.epam.task3.model;

import by.epam.task3.exception.InvalidCargoException;
import by.epam.task3.exception.PierUnavailableException;
import org.apache.log4j.Logger;

import java.util.Random;

public class Ship extends Thread {
    private static final Logger LOGGER = Logger.getLogger("Ship");
    private final int shipNumber;
    private final int MAX_CAPACITY = 10;
    private int cargo;
    private Harbor harbor;

    public Ship(Harbor harbor, int cargo, int shipNumber) {
        this.harbor = harbor;
        this.cargo = cargo;
        this.shipNumber = shipNumber;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int newCargo) throws InvalidCargoException {
        LOGGER.info("Cargo of ship № " + shipNumber + " before loading: " + cargo + " tons.");
        if (newCargo > MAX_CAPACITY || newCargo < 0) {
            throw new InvalidCargoException();
        }
        cargo = newCargo;
        LOGGER.info("Cargo of ship № " + shipNumber + ": " + cargo + " tons.");
    }

    @Override
    public void run() {
        Pier pier = null;
        Random random = new Random();
        try {
            pier = harbor.letMoor();
            pier.unloadShip(this, random.nextInt(8)+1);
            pier.loadShip(this, random.nextInt(6));
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
