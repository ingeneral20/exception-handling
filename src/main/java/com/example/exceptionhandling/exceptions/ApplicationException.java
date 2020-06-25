package com.example.exceptionhandling.exceptions;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }
}
