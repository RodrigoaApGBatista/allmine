package com.bookstore.allmine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bookstore.allmine")
@ConfigurationPropertiesScan
@SpringBootApplication
public class AllmineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllmineApplication.class, args);
	}

}
