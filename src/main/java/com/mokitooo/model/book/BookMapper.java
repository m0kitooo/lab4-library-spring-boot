package com.mokitooo.model.book;

import java.util.function.Function;

public interface BookMapper {
    Function<Book, String> BOOK_TO_TITLE = book -> book.title;
}
