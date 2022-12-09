package com.enigma.models.requests;

import lombok.Data;

@Data
public class VendorRequest {
    String vendorName;
    String products;
    float price;
}
