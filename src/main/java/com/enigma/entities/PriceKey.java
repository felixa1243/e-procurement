package com.enigma.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class PriceKey implements Serializable {
    @Column(name = "vendor_id")
    String vendorId;
    @Column(name = "product_id")
    String productId;
}
