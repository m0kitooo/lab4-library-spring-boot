package com.mokitooo.service.impl;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepository;
import com.mokitooo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.delete(bookId);
    }

    @Override
    public void block(int bookId) {
        bookRepository
                .findById(bookId)
                .ifPresent(book -> bookRepository.update(book.withNoAvailable()));
    }
}
