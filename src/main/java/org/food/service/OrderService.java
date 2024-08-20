package org.food.service;

import org.food.exception.OrderExistsException;
import org.food.exception.OrderNotFoundException;
import org.food.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;
}
