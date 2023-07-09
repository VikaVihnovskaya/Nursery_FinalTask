package com.vicky.exception;

public class AnimalsWithSameNameExistedException extends RuntimeException{

    public AnimalsWithSameNameExistedException(String message) {
        super(message);
    }
}
