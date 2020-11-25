package com.cardealership.cardealarship.exception;

public class CarIdExceptionResponse {
    private String car;

    public CarIdExceptionResponse(String car) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
