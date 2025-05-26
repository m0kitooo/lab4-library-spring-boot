package com.mokitooo.dto;

import com.mokitooo.model.Author;

import java.time.LocalDate;

public record DeleteBookDto(
        Author author,
        String title,
        LocalDate publishDate
) { }
