package org.food.controller;

import org.food.exception.OrderExistsException;
import org.food.exception.OrderNotFoundException;
import org.food.model.Order;
import org.food.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }

    public Order getOrderById(String id) throws OrderNotFoundException {
        return this.orderService.getOrderById(id);
    }

    public Order saveOrder(Order order) throws OrderExistsException {
        return this.orderService.save(order);
    }
}
