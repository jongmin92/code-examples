package com.jongmin.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jongmin.example.exception.NonExistingPersonException;

@RestControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(NonExistingPersonException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNonExistingPerson() {
    }
}
