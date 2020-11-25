package com.cardealership.cardealarship.component;

import com.cardealership.cardealarship.model.Car;
import org.springframework.stereotype.Component;

@Component
public interface ICarService {
    Car saveCar(Car car);
    Car findCar(String regNo);
}
