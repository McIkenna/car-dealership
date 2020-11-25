package com.cardealership.cardealarship.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    @NotEmpty(message = "Car must have make")
    private String make;
    @NotEmpty(message = "Car must have style")
    private String style;
    private String carModel;
    private String year;
    private String trimLevel;
    private String color;
    private int odometer;
    @Size(min = 7, max = 8, message = "Registeration Number must have Maximum of 8 Characters")
    @NotBlank(message = "Registeration number must not be empty")
    @Column(unique = true)
    private String regNo;
    private int carValue;
    private int period;
    private String plan;
    private double leasePrice;
    private int quantity;

}
