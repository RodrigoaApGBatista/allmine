package com.bookstore.allmine.adapters.outbound.entities;

import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ORDER")
public class OrderEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER", nullable = false)
    @ToString.Exclude
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="BOOKS", nullable = false)
    @ToString.Exclude
    private List<Book> books;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;
}
