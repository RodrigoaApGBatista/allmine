package com.bookstore.allmine.adapters.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class BookDto {

    @NotBlank
    private String id;

    @NotBlank
    private String title;

    private String id_user;

    @NotBlank
    private BigDecimal price;

}
