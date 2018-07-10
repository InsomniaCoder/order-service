package com.insomniacoder.orderservice.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "saleOrderId")
    private SalesOrder salesOrder;

    @ManyToOne
    @JoinColumn(name = "productId")

    private Product product;

}
