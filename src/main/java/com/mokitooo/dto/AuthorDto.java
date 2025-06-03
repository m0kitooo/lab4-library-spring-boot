package com.mokitooo.dto;

import com.mokitooo.model.Author;

import java.util.UUID;

public record AuthorDto(
        UUID id,
        String name,
        String surname
) {
    public Author toAuthor() {
        return new Author(UUID.randomUUID(), name, surname);
    }
}
