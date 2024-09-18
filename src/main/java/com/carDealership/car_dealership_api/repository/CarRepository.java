package com.carDealership.car_dealership_api.repository;
import com.carDealership.car_dealership_api.Model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CarRepository extends MongoRepository<Car, String> {
}
