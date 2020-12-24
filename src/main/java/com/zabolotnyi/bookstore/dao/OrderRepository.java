package com.zabolotnyi.bookstore.dao;

import com.zabolotnyi.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
