package com.bookstore.allmine.configuration;

import com.bookstore.allmine.AllmineApplication;
import com.bookstore.allmine.application.services.BookServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AllmineApplication.class)
public class BeanConfiguration {

    @Bean
    BookServiceImpl bookServiceImpl() {
        return new BookServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
