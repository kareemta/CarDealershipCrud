package com.carDealership.car_dealership_api.controller;
import com.carDealership.car_dealership_api.Model.Car;
import com.carDealership.car_dealership_api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // marks the class as a Spring REST controller
@RequestMapping("/api/cars") // base URL
public class CarController {

    @Autowired
    private CarService carService; // injecting car service to handle business logic

    // create a car
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // get all cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // get a car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable String id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // update a car
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable String id, @RequestBody Car carDetails) {
        Car updatedCar = carService.updateCar(id, carDetails);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }


}
