package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {

    private Long id;
    private User user;
    private List<Book> books;
    private BigDecimal total;
}
