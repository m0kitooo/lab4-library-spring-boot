package com.mokitooo.repository;

import com.mokitooo.exception.ResourceNotFoundException;
import com.mokitooo.model.book.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Repository
@NoArgsConstructor
public class BookRepositoryAsyncImpl implements BookRepository {
    private final Map<UUID, Book> books = new ConcurrentHashMap<>();
    private final Set<String> existingBookTitles = new ConcurrentSkipListSet<>();

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
    public Book save(Book book) {
        book = book.withTitle(book.getTitle().trim());

        if (existingBookTitles.contains(book.getTitle())) {
            throw new IllegalArgumentException("Book with such title already exists");
        }

        if (books.putIfAbsent(book.getId(), book) != null) {
            throw new IllegalArgumentException("Book already exists");
        }

        existingBookTitles.add(book.getTitle());
        return book;
    }

    @Override
    public synchronized void update(Book book) {
        book = book.withTitle(book.getTitle().trim());

        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    @Override
    public Book delete(UUID id) {
        if (!books.containsKey(id)) {
            throw new ResourceNotFoundException("Book with such id does not exist");
        }

        return books.remove(id);
    }
}
