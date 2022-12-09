package com.enigma.models.requests;

import lombok.Data;

@Data
public class ProductDto {
    String productName;
    String productCode;
    CategoryRequest category;
}
