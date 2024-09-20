package com.carDealership.car_dealership_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.carDealership.car_dealership_api.repository")
public class CarDealershipApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApiApplication.class, args);
	}

}
