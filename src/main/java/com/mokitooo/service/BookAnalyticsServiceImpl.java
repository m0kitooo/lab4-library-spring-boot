package com.mokitooo.service;

import com.mokitooo.dto.BookDto;
import com.mokitooo.dto.ConsumerDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookLoanRepository;
import com.mokitooo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mokitooo.dto.ConsumerDto.toDtoList;

@Service
@RequiredArgsConstructor
public class BookAnalyticsServiceImpl implements BookAnalyticsService {
    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository;

    @Override
    public Map<BookDto, List<ConsumerDto>> getGeneralBookReport() {
        return bookRepository
                .findAll()
                .stream()
                .collect(Collectors.toMap(
                        Book::toBookDto,
                        book -> toDtoList(bookLoanRepository.findConsumersByBookId(book.getId()))
                ));
    }
}
