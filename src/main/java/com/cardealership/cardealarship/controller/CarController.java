package com.cardealership.cardealarship.controller;

import com.cardealership.cardealarship.model.Car;
import com.cardealership.cardealarship.service.CarService;
import com.cardealership.cardealarship.service.MapErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    MapErrorService mapErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewCar(@Valid @RequestBody Car car, BindingResult result){
        ResponseEntity<?> errorMap = mapErrorService.MapErrorService(result);
        if(errorMap != null) return errorMap;

        Car car1 = carService.saveCar(car);
        return new ResponseEntity<Car>(car, HttpStatus.CREATED);
    }

    @GetMapping("/{regNo}")
    public ResponseEntity<?> getCarByRegNo(@PathVariable String regNo){

        Car car = carService.findCar(regNo);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Car> getAllCar(){
        return carService.findAll();
    }

    @DeleteMapping("/{regNo}")
    public ResponseEntity<?> deleteInfo(@PathVariable String regNo){
        carService.deleteCar(regNo);

        return new ResponseEntity<String>("Car with Registration Number: '" + regNo + "' was deleted", HttpStatus.OK);
    }
}
