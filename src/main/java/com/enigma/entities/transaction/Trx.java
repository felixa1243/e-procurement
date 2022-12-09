package com.enigma.entities.transaction;

import com.enigma.entities.ProductPrice;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sale")
@Data
public class Trx {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "transaction_id")
    String trxId;

    @OneToMany
    Set<ProductPrice> product = new HashSet<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date")
    Date trxDate;
    Integer qty;
}
