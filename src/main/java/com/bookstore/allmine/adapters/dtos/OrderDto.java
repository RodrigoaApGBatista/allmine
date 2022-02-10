package com.bookstore.allmine.adapters.dtos;

import com.bookstore.allmine.application.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {

    @Data
    public class Order {

        @NotBlank
        private Long id;

        @NotBlank
        private User user;

        @NotBlank
        private List<BookDto> books;

        @NotBlank
        private BigDecimal total;
    }

}
