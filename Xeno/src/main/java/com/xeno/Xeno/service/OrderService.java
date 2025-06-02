package com.xeno.Xeno.service;

import com.xeno.Xeno.model.Order;
import com.xeno.Xeno.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update order by ID
    public Optional<Order> updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setCustomer(updatedOrder.getCustomer());
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        });
    }

    // Delete order by ID
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
