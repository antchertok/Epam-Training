package by.epam.task3.controller;

import by.epam.task3.model.Harbor;
import by.epam.task3.model.Ship;

import static by.epam.task3.model.Harbor.HARBOR;

//Извиняюсь за загрузку такого варианта. В ближайшее время исправлю.
public class MultitaskingTest {
    public static void main(String[] args) {

        Harbor harbor = HARBOR;

        for(int i= 1; i < 27; i++){
            new Ship(harbor,6, i).start();
        }
    }
}
