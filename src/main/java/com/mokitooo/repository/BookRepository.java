package com.mokitooo.repository;

import com.mokitooo.model.book.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@NoArgsConstructor
public class BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    public BookRepository(Map<Long, Book> books) {
        this.books.putAll(books);
    }

    public Optional<Book> findById(long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public void save(Book book) {
        books.putIfAbsent(book.getId(), book);
    }

    public void update(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    public Book delete(long id) {
        return books.remove(id);
    }
}
