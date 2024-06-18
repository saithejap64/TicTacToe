package org.example.exception;

public class BotCountExceededException extends Exception{
    public BotCountExceededException() {
        super();
    }

    public BotCountExceededException(String message) {
        super(message);
    }

    public BotCountExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
