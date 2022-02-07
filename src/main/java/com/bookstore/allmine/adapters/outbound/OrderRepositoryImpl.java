package com.bookstore.allmine.adapters.outbound;


import com.bookstore.allmine.adapters.outbound.entities.OrderEntity;
import com.bookstore.allmine.application.domain.Order;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringDataOrderRepository orderRepository;

    public OrderRepositoryImpl(SpringDataOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Order save(Order order) {
        OrderEntity emailEntity = orderRepository.save(modelMapper.map(order, OrderEntity.class));
        return modelMapper.map(emailEntity, Order.class);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Order> findAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

}
