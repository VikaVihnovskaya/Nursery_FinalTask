package com.vicky.exception;

public class AnimalsNotFoundException extends RuntimeException{

    public AnimalsNotFoundException(String message) {
        super(message);
    }
}
