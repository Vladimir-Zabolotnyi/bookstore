package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.dao.OrderRepository;
import com.zabolotnyi.bookstore.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderToSave = null;
        Optional<Order> orderToBeUpdated = orderRepository.findById(order.getId());
        if (orderToBeUpdated.isPresent()) {
            orderToSave = orderToBeUpdated.get();
        } else log.error("Book not found ");
        orderToSave.setAddressOfDelivery(order.getAddressOfDelivery());
        orderToSave.setClient(order.getClient());
        orderToSave.setValueOfTheOrder(order.getValueOfTheOrder());
        return orderRepository.save(orderToSave);
    }

    @Override
    public String removeOrder(Long id) {
        orderRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }
}
