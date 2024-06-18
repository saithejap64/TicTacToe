package org.example.exception;

public class InvalidPlayerCountException extends Exception{
    public InvalidPlayerCountException() {
    }

    public InvalidPlayerCountException(String message) {
        super(message);
    }

    public InvalidPlayerCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
