package org.example.exception;

public class DuplicateSymbolFoundExcepion extends Exception{
    public DuplicateSymbolFoundExcepion() {
    }

    public DuplicateSymbolFoundExcepion(String message) {
        super(message);
    }

    public DuplicateSymbolFoundExcepion(String message, Throwable cause) {
        super(message, cause);
    }
}
