package by.epam.task3.exception;

public class InvalidCargoException extends Exception {
    public InvalidCargoException() {
        super();
    }

    public InvalidCargoException(String message) {
        super(message);
    }

    public InvalidCargoException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCargoException(Throwable cause) {
        super(cause);
    }
}
