package com.mokitooo;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookLoanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4LibrarySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4LibrarySpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println(ctx.getBean(Book.class));
            System.out.println(ctx.getBean(BookLoanRepository.class));
        };
    }
}
