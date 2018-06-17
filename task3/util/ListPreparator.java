package by.epam.task3.util;

import by.epam.task3.model.Pier;

import java.util.LinkedList;
import java.util.List;

public class ListPreparator {

    public List<Pier> prepareList(int amountOfPiers){
        LinkedList<Pier> piers = new LinkedList<>();
        for(int i= 0; i < amountOfPiers; i++){
            piers.add(new Pier());
        }
        return piers;
    }
}
