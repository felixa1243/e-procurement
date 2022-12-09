package com.enigma.models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryRequest {
    @NotBlank
    String categoryName;
}
