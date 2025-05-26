package com.mokitooo.repository;

import com.mokitooo.model.book.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@NoArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    public BookRepositoryImpl(Map<Long, Book> books) {
        this.books.putAll(books);
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void save(Book book) {
        books.putIfAbsent(book.getId(), book);
    }

    @Override
    public void update(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    @Override
    public Book delete(long id) {
        return books.remove(id);
    }
}
