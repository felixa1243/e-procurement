package com.enigma.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String vendorId;
    @Column(name = "vendor_name", length = 100)
    String vendorName;
    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    Set<ProductPrice> prices = new HashSet<>();
}
