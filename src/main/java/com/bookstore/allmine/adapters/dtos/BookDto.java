package com.bookstore.allmine.adapters.dtos;

import com.bookstore.allmine.application.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BookDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String title;

    private List<User> userAuthor;

    @NotBlank
    private BigDecimal price;

}
