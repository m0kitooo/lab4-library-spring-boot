package com.mokitooo.config;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookLoanRepository;
import com.mokitooo.repository.BookRepository;
import com.mokitooo.repository.ConsumerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book(1, null, "sigma", LocalDate.now());
    }

//    @Bean
//    public BookLoanRepository bookLoanRepository(ApplicationContext ctx) {
//        return new BookLoanRepository(ctx.getBean(BookRepository.class), ctx.getBean(ConsumerRepository.class));
//    }
}
