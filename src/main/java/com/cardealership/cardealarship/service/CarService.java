package com.cardealership.cardealarship.service;

import com.cardealership.cardealarship.component.ICarService;
import com.cardealership.cardealarship.exception.CarException;
import com.cardealership.cardealarship.model.Car;
import com.cardealership.cardealarship.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;


    public Car saveCar(Car car) {
        try {


            return carRepository.save(car);
        } catch (Exception ex) {
            throw new CarException("The Car '" + car.getRegNo() + "' already exist");
        }
    }


    public Car findCar(String regNo) {
        Car car = carRepository.findByRegNo(regNo);
        if (car == null) {
            throw new CarException("The Car with '" + regNo + "' does not exist");
        }
        return car;
    }


    public void deleteCar(String regNo) {
        Car car = carRepository.findByRegNo(regNo);

        if (car == null) {
            throw new CarException("Cannot delete, '" + regNo + "' does not exist");
        }
        carRepository.delete(car);
    }



    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

}
