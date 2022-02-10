package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String name;
    private List<Book> books;
}
