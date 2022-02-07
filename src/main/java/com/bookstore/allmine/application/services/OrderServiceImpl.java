package com.bookstore.allmine.application.services;


import com.bookstore.allmine.application.domain.Order;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.OrderRepository;
import com.bookstore.allmine.application.ports.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Override
    public List<Order> findAll(PageInfo pageInfo) {
        return orderRepository.findAll(pageInfo);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

}
