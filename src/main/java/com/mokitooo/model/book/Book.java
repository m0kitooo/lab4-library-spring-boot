package com.mokitooo.model.book;

import com.mokitooo.dto.BookDto;
import com.mokitooo.model.Author;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Book {
    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;
    private final Author author;
    @NonNull
    @Getter
    final String title;
    private final LocalDate publishDate;
    private final boolean available;

    public Book(UUID id, Author author, String title, LocalDate publishDate) {
        this(id, author, title, publishDate, true);
    }

    public Book withNoAvailable() {
        return new Book(id, author, title, publishDate, false);
    }

    public boolean matchesTitle(String title) {
        return equalsIgnoreCase(this.title, title);
    }

    public boolean titleContains(String word) {
        return containsIgnoreCase(this.title, word);
    }

    public BookDto toBookDto() {
        return new BookDto(author.toAuthorDto(), title, publishDate);
    }
}
