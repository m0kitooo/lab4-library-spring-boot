package com.mokitooo.dto;

import com.mokitooo.model.Consumer;

import java.util.List;
import java.util.UUID;

public record ConsumerDto(
        UUID id,
        String name,
        String surname
) {
    public static List<ConsumerDto> toDtoList(List<Consumer> consumers) {
        return consumers
                .stream()
                .map(Consumer::toDto)
                .toList();
    }
}

