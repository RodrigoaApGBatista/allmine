package com.bookstore.allmine.adapters.outbound;

import com.bookstore.allmine.adapters.outbound.entities.BookEntity;
import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class BookRepositoryImpl implements BookRepository {

    private final SpringDataBookRepository bookRepository;

    public BookRepositoryImpl(SpringDataBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Book save(Book book) {
        BookEntity emailEntity = bookRepository.save(modelMapper.map(book, BookEntity.class));
        return modelMapper.map(emailEntity, Book.class);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Book> findAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

}
