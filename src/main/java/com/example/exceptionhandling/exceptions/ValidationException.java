package com.example.exceptionhandling.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
