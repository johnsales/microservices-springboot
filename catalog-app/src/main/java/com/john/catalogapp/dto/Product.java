package com.john.catalogapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
    @Id
    private String uniqId;
    private String sku;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return uniqId != null && Objects.equals(uniqId, product.uniqId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


