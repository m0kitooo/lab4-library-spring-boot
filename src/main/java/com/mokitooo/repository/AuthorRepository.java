package com.mokitooo.repository;

import com.mokitooo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthorRepository {
    private final Map<Long, Author> authors = new HashMap<>();
}
