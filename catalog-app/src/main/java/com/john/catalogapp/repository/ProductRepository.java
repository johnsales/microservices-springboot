package com.john.catalogapp.repository;

import com.john.catalogapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findBySku(String sku);
    Product findByUniqId(String uniqId);
}

