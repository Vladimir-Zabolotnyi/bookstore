package com.zabolotnyi.bookstore.rest;


import com.zabolotnyi.bookstore.model.Author;
import com.zabolotnyi.bookstore.model.Order;
import com.zabolotnyi.bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public @ResponseBody
    List<Order> getOrder() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public @ResponseBody Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteOrder(@PathVariable("id") Long id) {
        orderService.removeOrder(id);
        return "Deleted";
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public @ResponseBody Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }


}
