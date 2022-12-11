package com.enigma.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_product")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String productId;
    @Column(name = "product_name", length = 100, nullable = false)
    String productName;
    @Column(name = "product_code", length = 100, nullable = false)
    String productCode;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;
}
