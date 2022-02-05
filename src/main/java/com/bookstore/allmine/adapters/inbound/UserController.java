package com.bookstore.allmine.adapters.inbound;

import com.bookstore.allmine.adapters.dtos.BookDto;
import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.ports.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class UserController {

    @Autowired
    BookService bookServicePort;

    @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Book> create(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return new ResponseEntity<>(bookServicePort.createBook(book), HttpStatus.CREATED);
    }

    @PutMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Book> update(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return new ResponseEntity<>(bookServicePort.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") UUID id) {
        bookServicePort.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<?> findAll(@PageableDefault(page = 0,
            size = 5,
            sort = "title",
            direction = Sort.Direction.DESC) Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Book> bookList = bookServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<Book>(bookList, pageable, bookList.size()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID bookId) {
        Optional<Book> bookModelOptional = bookServicePort.findById(bookId);
        return bookModelOptional.<ResponseEntity<Object>>map(book -> ResponseEntity.status(HttpStatus.OK).body(book))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found."));
    }

}
