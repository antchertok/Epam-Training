package by.epam.task3.model;

import by.epam.task3.exception.InvalidCargoException;
import org.apache.log4j.Logger;

/**
 * This class represents a pier where ships are trying to have a place.
 * Contains methods of loading/unloading ships.
 */
public class Pier {
    private static final Logger LOGGER = Logger.getLogger(Pier.class.getName());
    private int currentCargo;

    public int getCurrentCargo() {
        return currentCargo;
    }

    /**
     * This method is for transferring some cargo from ship to pier.
     *
     * @param ship  ship from which cargo is taken off
     * @param cargo weight of cargo to transfer
     */
    public void unloadShip(Ship ship, int cargo) {
        if (cargo < ship.getCargo()) {
            currentCargo += cargo;

            try {
                ship.setCargo(ship.getCargo() - cargo);
            } catch (InvalidCargoException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            currentCargo += ship.getCargo();

            try {
                ship.setCargo(0);
            } catch (InvalidCargoException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * This method is for transferring some cargo to ship.
     *
     * @param ship  ship for transferring cargo
     * @param cargo weight of cargo to transfer
     */
    public void loadShip(Ship ship, int cargo) throws InvalidCargoException {
        if ((ship.getMaxCapacity() - ship.getCargo()) < cargo) {
            throw new InvalidCargoException();
        }
        try {
            ship.setCargo(ship.getCargo() + cargo);
        } catch (InvalidCargoException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
