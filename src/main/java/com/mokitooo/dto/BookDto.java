package com.mokitooo.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BookDto(
        UUID id,
        AuthorDto author,
        String title,
        LocalDate publishDate,
        boolean available
) { }
