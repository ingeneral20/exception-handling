package com.example.exceptionhandling.exceptions;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String message) {
        super(message);
    }
}
