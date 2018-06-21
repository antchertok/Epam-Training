package by.epam.task3.controller;

import by.epam.task3.model.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static by.epam.task3.model.Harbor.HARBOR;

public class MultitaskingTest {
    private static final int AMOUNT_OF_SHIPS = 26;
    private static final int DEFAULT_CARGO = 6;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < AMOUNT_OF_SHIPS; i++) {
            exec.execute(new Ship(HARBOR, DEFAULT_CARGO));
        }

        exec.shutdown();
    }
}
