package com.john.productapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductRecord(String uniqId, String sku, String name, Boolean inStock) { }

