package com.john.inventoryapp.service;

import com.john.inventoryapp.dto.ProductAvailability;
import com.john.inventoryapp.repository.ProductAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ProductAvailabilityRepository repository;

    // Method to check product availability
    public boolean getAvailability(String uniqId) {
        return repository.findById(uniqId)
                .map(ProductAvailability::isInStock)
                .orElse(false);
    }

    // Optional: Method to get availability for multiple products
    public Map<String, Boolean> getAvailabilities(List<String> uniqIds) {
        Map<String, Boolean> availabilities = new HashMap<>();
        uniqIds.forEach(uniqId -> availabilities.put(uniqId, getAvailability(uniqId)));
        return availabilities;
    }
}

