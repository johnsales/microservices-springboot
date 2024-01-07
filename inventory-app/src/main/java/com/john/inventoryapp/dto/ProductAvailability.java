package com.john.inventoryapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "product_availability")
@NoArgsConstructor
@AllArgsConstructor
public class ProductAvailability {
    @Id
    private String uniqId;
    private boolean inStock;
}
