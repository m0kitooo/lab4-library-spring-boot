package com.mokitooo.service;

import com.mokitooo.dto.DeleteBookDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryAsyncImpl bookRepositoryAsyncImpl;

    @Override
    public void registerBook(Book book) {
        bookRepositoryAsyncImpl.save(book);
    }

    @Override
    public DeleteBookDto deleteBook(UUID bookId) {
        return bookRepositoryAsyncImpl.delete(bookId).toDeleteBookDto();
    }

    @Override
    public void block(UUID bookId) {
        bookRepositoryAsyncImpl
                .findById(bookId)
                .ifPresent(book -> bookRepositoryAsyncImpl.update(book.withNoAvailable()));
    }
}
