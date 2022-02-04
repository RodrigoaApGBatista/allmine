package com.bookstore.allmine.adapters.outbound.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "BOOK")
public class BookEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "id_user")
    private String id_user;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookEntity that = (BookEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
