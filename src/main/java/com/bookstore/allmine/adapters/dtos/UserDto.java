package com.bookstore.allmine.adapters.dtos;

import com.bookstore.allmine.application.domain.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    @Data
    public class Order {

        @NotBlank
        private UUID id;

        @NotBlank
        private User name;


        private List<BookDto> books;
    }


}
