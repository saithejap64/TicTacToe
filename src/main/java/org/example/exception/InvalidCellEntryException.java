package org.example.exception;

public class InvalidCellEntryException extends Exception{
    public InvalidCellEntryException() {
    }

    public InvalidCellEntryException(String message) {
        super(message);
    }

    public InvalidCellEntryException(String message, Throwable cause) {
        super(message, cause);
    }
}
