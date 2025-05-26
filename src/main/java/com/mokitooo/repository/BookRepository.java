package com.mokitooo.repository;

import com.mokitooo.model.book.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Optional<Book> findById(UUID id);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    Book delete(UUID id);
}
