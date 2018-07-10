package com.insomniacoder.orderservice.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private String status;
    private String promotion;

    private Double subnet;
    private Double discount;
    private Double net;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    Set<Item> items;

}
