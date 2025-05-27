package com.mokitooo.service;

import com.mokitooo.dto.CreateBookDto;
import com.mokitooo.dto.BookDto;
import com.mokitooo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookSearchService bookSearchService;

    @Override
    public BookDto registerBook(CreateBookDto createBookDto) {
        return bookRepository.save(createBookDto.toBook()).toBookDto();
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
