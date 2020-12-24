package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    Order updateOrder(Order order);

    String removeOrder(Long id);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
}
