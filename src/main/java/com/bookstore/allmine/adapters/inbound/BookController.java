package com.bookstore.allmine.adapters.inbound;

import com.bookstore.allmine.adapters.dtos.BookDto;
import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.ports.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    BookService bookServicePort;

    @PostMapping("/publish-book")
    public ResponseEntity<Book> sendingBook(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return new ResponseEntity<>(bookServicePort.createBook(book), HttpStatus.CREATED);
    }

    @PostMapping("/edit-book")
    public ResponseEntity<Book> sendingBook(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return new ResponseEntity<>(bookServicePort.updateBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-book")
    public ResponseEntity<Book> sendingBook(@RequestBody @Valid BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return new ResponseEntity<>(bookServicePort.deleteBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getAllBooks(@PageableDefault(page = 0, size = 5, sort = "bookId", direction = Sort.Direction.DESC) Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Book> bookList = bookServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<Book>(bookList, pageable, bookList.size()), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Object> getOneBook(@PathVariable(value="bookId") UUID bookId){
        Optional<Book> bookModelOptional = bookServicePort.findById(bookId);
        if(!bookModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());
        }


}
