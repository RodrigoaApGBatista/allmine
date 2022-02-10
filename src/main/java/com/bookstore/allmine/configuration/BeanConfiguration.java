package com.bookstore.allmine.configuration;

import com.bookstore.allmine.AllmineApplication;
import com.bookstore.allmine.application.ports.BookRepository;
import com.bookstore.allmine.application.ports.OrderRepository;
import com.bookstore.allmine.application.ports.UserRepository;
import com.bookstore.allmine.application.services.BookServiceImpl;
import com.bookstore.allmine.application.services.OrderServiceImpl;
import com.bookstore.allmine.application.services.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AllmineApplication.class)
public class BeanConfiguration {

    @Bean
    BookServiceImpl bookServiceImpl(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }

    @Bean
    UserServiceImpl userServiceImpl(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    OrderServiceImpl orderServiceImpl(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
