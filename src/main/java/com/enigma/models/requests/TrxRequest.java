package com.enigma.models.requests;

import com.enigma.entities.Product;
import com.enigma.entities.ProductPrice;
import lombok.Data;

import java.util.Date;

@Data
public class TrxRequest {
    String productId;
    String vendorId;
    Integer qty;
    Date date;
}