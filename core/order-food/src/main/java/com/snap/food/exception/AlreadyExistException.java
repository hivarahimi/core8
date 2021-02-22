package com.snap.food.exception;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException() {
        super("The item is already there");
    }

}
