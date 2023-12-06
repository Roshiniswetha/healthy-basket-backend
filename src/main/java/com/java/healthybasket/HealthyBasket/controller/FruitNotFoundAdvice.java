package com.java.healthybasket.HealthyBasket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class FruitNotFoundAdvice {
    @ExceptionHandler(value = FruitNotFoundException.class)
    public ResponseEntity<Object> exception(FruitNotFoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
