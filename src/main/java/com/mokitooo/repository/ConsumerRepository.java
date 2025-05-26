package com.mokitooo.repository;

import com.mokitooo.model.Consumer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsumerRepository {
    Optional<Consumer> findById(UUID id);
    List<Consumer> findAll();
}
