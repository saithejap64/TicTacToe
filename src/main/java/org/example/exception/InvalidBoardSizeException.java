package org.example.exception;

public class InvalidBoardSizeException extends Exception{
    public InvalidBoardSizeException() {
    }

    public InvalidBoardSizeException(String message) {
        super(message);
    }

    public InvalidBoardSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
