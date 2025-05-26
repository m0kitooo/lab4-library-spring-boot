package com.mokitooo.dto;

import com.mokitooo.model.Consumer;

public record ReturnBookDto(
        Consumer consumer,
        String title
) { }
