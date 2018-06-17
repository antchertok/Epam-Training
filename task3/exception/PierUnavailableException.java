package by.epam.task3.exception;

public class PierUnavailableException extends Exception{
    public PierUnavailableException() {
        super();
    }

    public PierUnavailableException(String message) {
        super(message);
    }

    public PierUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public PierUnavailableException(Throwable cause) {
        super(cause);
    }
}
