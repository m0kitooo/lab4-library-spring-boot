package com.mokitooo.config;

import com.mokitooo.model.book.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.UUID;

@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book(UUID.randomUUID(), null, "sigma", LocalDate.now());
    }

//    @Bean
//    public BookLoanRepository bookLoanRepository(ApplicationContext ctx) {
//        return new BookLoanRepository(ctx.getBean(BookRepository.class), ctx.getBean(ConsumerRepository.class));
//    }
}
