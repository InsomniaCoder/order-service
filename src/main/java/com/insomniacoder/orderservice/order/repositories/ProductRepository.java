package com.insomniacoder.orderservice.order.repositories;

import com.insomniacoder.orderservice.order.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}