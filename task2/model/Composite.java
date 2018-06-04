package by.epam.task2.model;

import java.util.ArrayList;

/**
 * Class containing information of a higher level in "Composite"
 */
public class Composite implements Component {
    private ArrayList<Component> branches;

    public Composite(ArrayList<Component> branches) {
        this.branches = branches;
    }

    @Override
    public ArrayList<Component> getData() {
        return branches;
    }

    public boolean contains(String str) {
        for (Component component : branches) {
            if (component.contains(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Component component : branches) {
            result.append(component.toString());
        }

        return result.toString();
    }
}
