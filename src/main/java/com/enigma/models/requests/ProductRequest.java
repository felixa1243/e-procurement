package com.enigma.models.requests;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class ProductRequest {
    @Length(min = 3, max = 100)
    String productName;
    @NotBlank
    String productCode;
    @NotBlank
    String categoryName;
}
