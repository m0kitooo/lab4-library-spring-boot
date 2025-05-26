package com.mokitooo.service;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryImpl bookRepositoryImpl;

    @Override
    public void registerBook(Book book) {
        bookRepositoryImpl.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepositoryImpl.delete(bookId);
    }

    @Override
    public void block(int bookId) {
        bookRepositoryImpl
                .findById(bookId)
                .ifPresent(book -> bookRepositoryImpl.update(book.withNoAvailable()));
    }
}
