package com.mokitooo.dto;

import com.mokitooo.model.Author;

import java.time.LocalDate;

public record BookDto(
        Author author,
        String title,
        LocalDate publishDate
) { }
