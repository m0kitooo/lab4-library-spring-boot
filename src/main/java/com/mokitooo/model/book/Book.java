package com.mokitooo.model.book;

import com.mokitooo.model.Author;
import lombok.*;

import java.time.LocalDate;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Book {
    @Getter
    @EqualsAndHashCode.Include
    private final long id;
    private final Author author;
    @NonNull
    final String title;
    private final LocalDate publishDate;
    private final boolean available;

    public Book(long id, Author author, String title, LocalDate publishDate) {
        this(id, author, title, publishDate, true);
    }

    public Book withNoAvailable() {
        return new Book(id, author, title, publishDate, false);
    }

    public boolean titleContains(String word) {
        return containsIgnoreCase(this.title, word);
    }
}
