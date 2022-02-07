package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private UUID id;
    private User user;
    private List<Book> books;
    private BigDecimal total;
}
