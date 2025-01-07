package com.example.carmart.repository;

import com.example.carmart.models.Cars;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CarsRepository extends CrudRepository<Cars, Long> {

    // Find all distinct car brands
    @Query("SELECT DISTINCT c.brand FROM Cars c")
    List<String> findAllBrands();

    // Find cars by a specific brand
    List<Cars> findCarsByBrand(String brand);

    // Find cars with price greater than a specified value
    List<Cars> findByPriceGreaterThan(int price);

    // Find cars with price less than a specified value
    List<Cars> findByPriceLessThan(int price);
}

