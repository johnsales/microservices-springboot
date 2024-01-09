package com.john.productapp.client;

import com.john.productapp.dto.ProductRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "catalog-service")
public interface CatalogClient {
    @GetMapping("/api/catalog/{uniqId}")
    Optional<ProductRecord> getProductByUniqId(@PathVariable String uniqId);

    @GetMapping("/api/catalog/sku/{sku}")
    List<ProductRecord> getProductsBySku(@PathVariable String sku);
}

