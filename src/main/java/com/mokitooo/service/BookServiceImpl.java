package com.mokitooo.service;

import com.mokitooo.dto.CreateBookDto;
import com.mokitooo.dto.BookDto;
import com.mokitooo.repository.BookRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryAsyncImpl bookRepository;
    private final BookSearchService bookSearchService;

    @Override
    public void registerBook(CreateBookDto createBookDto) {
        bookRepository.save(createBookDto.toBook());
    }

    @Override
    public BookDto deleteBook(String title) {
        UUID bookId = bookSearchService.findByTitle(title).getFirst().getId();

        return bookRepository.delete(bookId).toBookDto();
    }

    @Override
    public void block(String title) {
        UUID bookId = bookSearchService.findByTitle(title).getFirst().getId();

        bookRepository
                .findById(bookId)
                .ifPresent(book -> bookRepository.update(book.withNoAvailable()));
    }
}
