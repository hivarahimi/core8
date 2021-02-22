package com.snap.food.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("The item was not there");
    }

}
