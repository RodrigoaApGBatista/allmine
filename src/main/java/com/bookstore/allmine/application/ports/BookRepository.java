package com.bookstore.allmine.application.ports;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    Book save(Book book);
    void delete(UUID id);
    List<Book> findAll(PageInfo pageInfo);
    Optional<Book> findById(UUID id);

}
