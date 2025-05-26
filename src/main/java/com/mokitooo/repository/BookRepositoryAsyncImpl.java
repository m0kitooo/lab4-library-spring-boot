package com.mokitooo.repository;

import com.mokitooo.model.book.Book;
import com.mokitooo.util.IdentityGenerator;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@NoArgsConstructor
public class BookRepositoryAsyncImpl implements BookRepository {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final IdentityGenerator identityGenerator = new IdentityGenerator();

    public BookRepositoryAsyncImpl(Map<Long, Book> books) {
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
        if (book.getId() == null) {
            book.withId(identityGenerator.generate());
        }
        books.putIfAbsent(book.getId(), book);
    }

    @Override
    public synchronized void update(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    @Override
    public Book delete(long id) {
        return books.remove(id);
    }
}
