package com.john.productapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "inventoryClient", url = "http://localhost:8081")
public interface InventoryClient {

    @GetMapping("/api/inventory")
    Map<String, Boolean> getAvailability(@RequestParam("uniqIds") List<String> uniqIds);
}
