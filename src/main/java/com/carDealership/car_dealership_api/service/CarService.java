package com.carDealership.car_dealership_api.service;
import com.carDealership.car_dealership_api.Model.Car;
import com.carDealership.car_dealership_api.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// service handles business logic and interacts with the repository
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // creating a car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // if we want to create a list of all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // get a specific car by its id
    public Optional<Car> getCarById(String id) {
        return carRepository.findById(id);
    }

    // update information regarding a car
    public Car updateCar(String id, Car carDetails) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setPrice(carDetails.getPrice());
            return carRepository.save(car);
        }
        return null;
    }

    // delete a car
    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }
}
