package com.bookstore.allmine.application.services;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.BookRepository;
import com.bookstore.allmine.application.ports.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(UUID id) {
        bookRepository.delete(id);
    }

    @Override
    public List<Book> findAll(PageInfo pageInfo) {
        return bookRepository.findAll(pageInfo);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookRepository.findById(id);
    }

}
