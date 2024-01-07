package com.john.productapp.controller;

import com.john.productapp.dto.ProductRecord;
import com.john.productapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{uniqId}")
    public ResponseEntity<ProductRecord> getAvailableProductByUniqId(@PathVariable String uniqId) {
        return productService.getAvailableProductByUniqId(uniqId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<List<ProductRecord>> getAvailableProductsBySku(@PathVariable String sku) {
        return productService.getAvailableProductsBySku(sku)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
