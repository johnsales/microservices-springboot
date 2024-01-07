package com.john.inventoryapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "product_availability")
@NoArgsConstructor
@AllArgsConstructor
public class ProductAvailability {
    @Id
    private String uniqId;
    private boolean inStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductAvailability that = (ProductAvailability) o;
        return uniqId != null && Objects.equals(uniqId, that.uniqId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
