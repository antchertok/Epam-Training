package by.epam.task2.model;

/**
 * Class containing information of a lower level in "Composite"
 *
 * @param <T> type of stored data
 */
public class Leaf<T> implements Component {
    private T data;

    public Leaf(T line) {
        this.data = line;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public boolean contains(String str) {
        return toString().contains(str);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
