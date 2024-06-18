package org.example.exception;

public class CellOccupiedException extends Exception{
    public CellOccupiedException() {
    }

    public CellOccupiedException(String message) {
        super(message);
    }

    public CellOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
