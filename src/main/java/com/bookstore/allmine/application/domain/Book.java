package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
    private User userAuthor;
    private BigDecimal price;
}
