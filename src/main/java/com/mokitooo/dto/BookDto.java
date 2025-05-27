package com.mokitooo.dto;

import java.time.LocalDate;

public record BookDto(
        AuthorDto author,
        String title,
        LocalDate publishDate
) { }
