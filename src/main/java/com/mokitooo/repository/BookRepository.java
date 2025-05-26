package com.mokitooo.repository;

import com.mokitooo.model.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(long id);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    Book delete(long id);
}
