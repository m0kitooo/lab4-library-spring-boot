package com.mokitooo.service;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryAsyncImpl bookRepositoryAsyncImpl;

    @Override
    public void registerBook(Book book) {
        bookRepositoryAsyncImpl.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepositoryAsyncImpl.delete(bookId);
    }

    @Override
    public void block(int bookId) {
        bookRepositoryAsyncImpl
                .findById(bookId)
                .ifPresent(book -> bookRepositoryAsyncImpl.update(book.withNoAvailable()));
    }
}
