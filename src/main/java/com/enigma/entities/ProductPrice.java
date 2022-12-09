package com.enigma.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_product_price")
@Data
public class ProductPrice {
    @EmbeddedId
    PriceKey priceKey = new PriceKey();
    @ManyToOne
    @MapsId("vendorId")
    @JoinColumn(name = "vendor_id")
    Vendor vendor;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    float price;
    boolean isActive;
}
