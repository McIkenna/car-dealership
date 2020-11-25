package com.cardealership.cardealarship.repository;

import com.cardealership.cardealarship.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {


    Car findByRegNo(String regNo);

    @Override
    Iterable<Car> findAll();


}
