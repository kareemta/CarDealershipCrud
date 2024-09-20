package com.carDealership.car_dealership_api.repository;
import com.carDealership.car_dealership_api.Model.Car;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
// extends mongo repository interface which gives us built in crud operations
public interface CarRepository extends MongoRepository<Car, String> {
}
