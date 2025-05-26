package com.mokitooo.dto;

import java.time.LocalDate;

public record CreateBookDto(
        String title,
        LocalDate publishDate,
        boolean available
) { }
