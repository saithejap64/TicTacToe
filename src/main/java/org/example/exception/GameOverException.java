package org.example.exception;

public class GameOverException extends Exception{
    public GameOverException() {
    }

    public GameOverException(String message) {
        super(message);
    }

    public GameOverException(String message, Throwable cause) {
        super(message, cause);
    }
}
