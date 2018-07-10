package com.insomniacoder.orderservice.order.repositories;

import com.insomniacoder.orderservice.order.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}