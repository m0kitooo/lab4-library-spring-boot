package com.mokitooo.repository;

import com.mokitooo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthorRepositoryAsyncImpl implements AuthorRepository {
    private final Map<Long, Author> authors = new ConcurrentHashMap<>();
}
