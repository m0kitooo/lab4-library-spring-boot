package com.mokitooo.dto;

import com.mokitooo.model.Consumer;

public record BorrowBookDto(
        Consumer consumer,
        String bookTitle
) { }
