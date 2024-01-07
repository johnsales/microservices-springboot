package com.john.catalogapp.controller;

import com.john.catalogapp.dto.Product;
import com.john.catalogapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductRepository productRepository;

    @GetMapping("/{uniqId}")
    public ResponseEntity<Product> getProductByUniqId(@PathVariable String uniqId) {
        Product product = productRepository.findByUniqId(uniqId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<List<Product>> getProductsBySku(@PathVariable String sku) {
        List<Product> products = productRepository.findBySku(sku);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
}
