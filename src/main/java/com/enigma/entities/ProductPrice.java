package com.enigma.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_product_price")
@Getter
@Setter
@ToString
public class ProductPrice {
    float price;
    boolean isActive;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String priceId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
