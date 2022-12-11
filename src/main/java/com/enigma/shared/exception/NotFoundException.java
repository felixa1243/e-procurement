package com.enigma.shared.exception;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Resource you've searched is not found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
