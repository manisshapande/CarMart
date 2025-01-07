package com.example.carmart;

import com.example.carmart.models.Cars;
import com.example.carmart.repository.CarsRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMartApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(CarsRepository carRepository) {
		return (args) -> {
			//save few Cars Details
			carRepository.save(new Cars("Hyundai", "I10", "2019", 10000, 300000, "Petrol"));
			carRepository.save(new Cars("Hyundai", "I20", "2018", 20000, 200000, "Diesel"));
			carRepository.save(new Cars("Hyundai", "Verna", "2019", 15000, 250000, "Petrol"));
			carRepository.save(new Cars("Tata", "Bolt", "2019", 15000, 250000, "Petrol"));
			carRepository.save(new Cars("Maruthi Suzuki", "Ciaz", "2019", 5000, 600000, "Petrol"));
			carRepository.save(new Cars("Honda", "Jazz", "2018", 20000, 200000, "Diesel"));
			carRepository.save(new Cars("Honda", "City", "2019", 15000, 400000, ""));
			carRepository.save(new Cars("Maruthi Suzuki", "Ertiga", "2018", 10000, 550000, "Petrol"));
			carRepository.save(new Cars("Tata", "Nexon", "2019", 5000, 600000, "Petrol"));

			Logger log = LoggerFactory.getLogger(CarMartApplication.class);


			log.info("Cars found with findAll():");
			log.info("---------------------------------");
			carRepository.findAll().forEach(cars -> log.info(cars.toString()));

		};
	}
}
