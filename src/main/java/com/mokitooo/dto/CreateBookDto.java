package com.mokitooo.dto;

import com.mokitooo.model.book.Book;

import java.time.LocalDate;
import java.util.UUID;

public record CreateBookDto(
        AuthorDto author,
        String title,
        LocalDate publishDate
) {
    public Book toBook() {
        return new Book(UUID.randomUUID(), author.toAuthor(), title, publishDate);
    }
}
