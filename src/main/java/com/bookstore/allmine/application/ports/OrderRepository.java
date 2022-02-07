package com.bookstore.allmine.application.ports;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.Order;
import com.bookstore.allmine.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);
    void delete(Long id);
    List<Order> findAll(PageInfo pageInfo);
    Optional<Order> findById(Long id);

}
