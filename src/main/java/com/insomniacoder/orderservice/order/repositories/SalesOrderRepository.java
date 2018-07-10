package com.insomniacoder.orderservice.order.repositories;

import com.insomniacoder.orderservice.order.entities.SalesOrder;
import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {
}