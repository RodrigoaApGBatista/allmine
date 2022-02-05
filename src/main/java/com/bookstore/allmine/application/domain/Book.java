package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
    private String id_user;
    private BigDecimal price;
}
