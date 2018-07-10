package com.insomniacoder.orderservice.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String sku;
    private String name;
    private String uom;
    private Double price;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    private Set<Item> items;

}
