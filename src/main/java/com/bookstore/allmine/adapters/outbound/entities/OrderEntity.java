package com.bookstore.allmine.adapters.outbound.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ORDER_BOOK")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER", nullable = false)
    @ToString.Exclude
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="BOOKS", nullable = false)
    @ToString.Exclude
    private List<BookEntity> books;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;
}
