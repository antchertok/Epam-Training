package by.epam.task3.model;

import by.epam.task3.exception.InvalidCargoException;

public class Pier {
    private int currentCargo;

    public int getCurrentCargo(){
        return currentCargo;
    }

    public void unloadShip(Ship ship) {
        currentCargo += ship.getCargo();

        try {
            ship.setCargo(0);
        } catch (InvalidCargoException e) {
            e.printStackTrace();//LOG IT!!!
        }
    }

    public void unloadShip(Ship ship, int cargo) {
        if (cargo < ship.getCargo()) {
            currentCargo += cargo;

            try {
                ship.setCargo(ship.getCargo() - cargo);
            } catch (InvalidCargoException e) {
                e.printStackTrace();//LOG IT!!!
            }
        } else {
            currentCargo += ship.getCargo();

            try {
                ship.setCargo(0);
            } catch (InvalidCargoException e) {
                e.printStackTrace();//LOG IT!!!
            }
        }
    }

    public void loadShip(Ship ship, int cargo) throws InvalidCargoException {
        if ((ship.getMaxCapacity() - ship.getCargo()) < cargo) {
            throw new InvalidCargoException();
        }
        try{
            ship.setCargo(ship.getCargo()+cargo);

        }catch (InvalidCargoException e){
            e.printStackTrace();//LOG IT!!!
        }
    }
}
