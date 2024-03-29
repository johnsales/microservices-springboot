package com.john.catalogapp.controller;

import com.john.catalogapp.dto.Product;
import com.john.catalogapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

//    @Value("${config-placeholder}")
//    private String configPlaceholder;

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
        if ("error".equals(sku)) {
            throw new RuntimeException("Simulated server error");
        }
        List<Product> products = productRepository.findBySku(sku);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    //confi-server needs to start first
//    @GetMapping("/config")
//    public ResponseEntity<String> getConfig() {
//        return ResponseEntity.ok(configPlaceholder);
//    }

}
