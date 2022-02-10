package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {

    private Long id;
    private String title;
    private User userAuthor;
    private BigDecimal price;
}
