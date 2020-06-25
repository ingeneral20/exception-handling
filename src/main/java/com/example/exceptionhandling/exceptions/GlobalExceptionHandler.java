package com.example.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            StringIndexOutOfBoundsException.class,
            NullPointerException.class,
            RuntimeException.class
    })
    @ResponseBody @ResponseStatus(INTERNAL_SERVER_ERROR)
    public String handleExceptions(Throwable throwable) {
        throwable.printStackTrace();
        return "API Error";
    }

    @ExceptionHandler(value = NoDataFoundException.class)
    @ResponseBody @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoDataFoundException(Throwable throwable) {
        return "No data found";
    }

    @ExceptionHandler(value = ApplicationException.class)
    @ResponseBody @ResponseStatus(INTERNAL_SERVER_ERROR)
    public String handleApplicationException(Throwable throwable) {
        return "API Error";
    }

    @ExceptionHandler(value = ValidationException.class)
    @ResponseBody @ResponseStatus(BAD_REQUEST)
    public String handleValidationException(Throwable throwable) {
        return "Validation Error";
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        List<String> errorMessages =
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(violation -> violation.getDefaultMessage())
                        .collect(Collectors.toList());
        return "Validation Error : " + errorMessages.toString();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody @ResponseStatus(INTERNAL_SERVER_ERROR)
    public String handleUnknownExceptions(Throwable throwable) {
        throwable.printStackTrace();
        return "API Error";
    }

}
