package com.bookstore.allmine.application.services;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookServiceImpl implements BookService {

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Book> findAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Optional<Book> findById(UUID bookId) {
        return Optional.empty();
    }

}
