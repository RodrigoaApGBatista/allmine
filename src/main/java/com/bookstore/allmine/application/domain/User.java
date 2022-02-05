package com.bookstore.allmine.application.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String name;
}
