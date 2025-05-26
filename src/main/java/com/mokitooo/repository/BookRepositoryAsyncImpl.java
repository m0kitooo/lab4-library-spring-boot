package com.mokitooo.repository;

import com.mokitooo.model.book.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@NoArgsConstructor
public class BookRepositoryAsyncImpl implements BookRepository {
    private final Map<UUID, Book> books = new ConcurrentHashMap<>();

    public BookRepositoryAsyncImpl(Map<UUID, Book> books) {
        this.books.putAll(books);
    }

    @Override
    public Optional<Book> findById(UUID id) {
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
    public synchronized void update(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    @Override
    public Book delete(UUID id) {
        return books.remove(id);
    }
}
