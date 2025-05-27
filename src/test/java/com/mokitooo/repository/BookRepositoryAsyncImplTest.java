package com.mokitooo.repository;

import com.mokitooo.model.Author;
import com.mokitooo.model.book.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class BookRepositoryAsyncImplTest {
    private BookRepositoryAsyncImpl bookRepositoryAsyncImpl;

    @BeforeEach
    void setUp() throws Exception {
        bookRepositoryAsyncImpl = new BookRepositoryAsyncImpl();
    }

    @Test
    void returnsTrueIfBookGetsAddedToRepository() {
        Author author = new Author(UUID.randomUUID(), "John", "Pork");
        Book book = new Book(UUID.randomUUID(), author, "sigma book", LocalDate.now());
        Assertions.assertThat(bookRepositoryAsyncImpl.save(book)).isEqualTo(book);
        Assertions.assertThat(bookRepositoryAsyncImpl.findAll()).hasSize(1).containsExactly(book);
    }
}
