package com.mokitooo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Consumer {
    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;
    private final String name;
    private final String surname;
}
