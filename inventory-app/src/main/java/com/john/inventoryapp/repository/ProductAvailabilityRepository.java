package com.john.inventoryapp.repository;

import com.john.inventoryapp.dto.ProductAvailability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAvailabilityRepository extends JpaRepository<ProductAvailability, String> {
}


