package com.john.productapp.service;

import com.john.productapp.client.CatalogClient;
import com.john.productapp.client.InventoryClient;
import com.john.productapp.dto.ProductRecord;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CatalogClient catalogClient;
    private final InventoryClient inventoryClient;

    @CircuitBreaker(name = "available-products-uni-id", fallbackMethod = "defaultFallbackForCatalogAndInventory")
    public Optional<ProductRecord> getAvailableProductByUniqId(String uniqId) {
        Optional<ProductRecord> productOpt = catalogClient.getProductByUniqId(uniqId);
        if (productOpt.isPresent() && inventoryClient.getAvailability(Collections.singletonList(uniqId)).getOrDefault(uniqId, false)) {
            return productOpt;
        }
        return Optional.empty();
    }

    @CircuitBreaker(name = "available-products-sku", fallbackMethod = "defaultFallbackForCatalogAndInventory")
    public Optional<List<ProductRecord>> getAvailableProductsBySku(String sku) {
        List<ProductRecord> products = catalogClient.getProductsBySku(sku);
        if (products.isEmpty()) {
            return Optional.empty();
        }
        Map<String, Boolean> availabilityMap = inventoryClient.getAvailability(
                products.stream().map(ProductRecord::uniqId).collect(Collectors.toList())
        );
        List<ProductRecord> availableProducts = products.stream()
                .filter(product -> availabilityMap.getOrDefault(product.uniqId(), false))
                .collect(Collectors.toList());

        return availableProducts.isEmpty() ? Optional.empty() : Optional.of(availableProducts);
    }

    private Optional<List<ProductRecord>> defaultFallbackForCatalogAndInventory(String sku, Throwable t) {
        throw new RuntimeException("Catalog or Inventory service is unavailable");
    }
}

