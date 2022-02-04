package com.bookstore.allmine.adapters.outbound;

import com.bookstore.allmine.adapters.outbound.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataBookRepository extends JpaRepository<BookEntity, UUID> {
}