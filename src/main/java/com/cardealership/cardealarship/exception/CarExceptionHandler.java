package com.cardealership.cardealarship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CarExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public final ResponseEntity<Object> handleCarException(CarException ex, WebRequest request){
        CarIdExceptionResponse exceptionResponse = new CarIdExceptionResponse(ex.getMessage());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
