package com.icoffiel.frameworkplayground.spring.spring.rest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<Void> handleEmptyResultDataAccessException(EmptyResultDataAccessException ignore) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
