package com.enigma.shared;

public class NotFoundException extends Exception{
    public NotFoundException() {
        super("Resource you've searched is not found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
