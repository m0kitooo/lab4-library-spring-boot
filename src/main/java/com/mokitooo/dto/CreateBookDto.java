package com.mokitooo.dto;

import com.mokitooo.model.Author;
import com.mokitooo.model.book.Book;

import java.time.LocalDate;
import java.util.UUID;

public record CreateBookDto(
        Author author,
        String title,
        LocalDate publishDate
) {
    public Book toBook() {
        return new Book(UUID.randomUUID(), author, title, publishDate);
    }
}
