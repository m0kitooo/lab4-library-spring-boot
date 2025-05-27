package com.mokitooo.model;

import com.mokitooo.dto.AuthorDto;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Author {
    @EqualsAndHashCode.Include
    private final UUID id;
    private final String name;
    private final String surname;

    public AuthorDto toAuthorDto() {
        return new AuthorDto(name, surname);
    }
}
