package com.mokitooo.repository;

import com.mokitooo.model.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConsumerRepository {
    Optional<Consumer> findById(long id);
    List<Consumer> findAll();
}
