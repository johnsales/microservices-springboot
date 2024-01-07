package com.john.inventoryapp.controller;

import com.john.inventoryapp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public Map<String, Boolean> getAvailability(@RequestParam List<String> uniqIds) {
        return inventoryService.getAvailabilities(uniqIds);
    }
}
