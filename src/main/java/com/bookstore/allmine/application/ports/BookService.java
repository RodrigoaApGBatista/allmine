package com.bookstore.allmine.application.ports;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    Book createBook(Book book);

    Book updateBook(Book book);

    void delete(Long id);

    List<Book> findAll(PageInfo pageInfo);

    Optional<Book> findById(UUID bookId);
}
