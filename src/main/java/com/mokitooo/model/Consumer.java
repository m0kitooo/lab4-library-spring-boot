package com.mokitooo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Consumer {
    @Getter
    @EqualsAndHashCode.Include
    private final long id;
    private final String name;
    private final String surname;
}
