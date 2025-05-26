package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@NoArgsConstructor
public class ConsumerRepositoryAsyncImpl implements ConsumerRepository {
    private final Map<Long, Consumer> consumers = new ConcurrentHashMap<>();

    public ConsumerRepositoryAsyncImpl(Map<Long, Consumer> consumers) {
        this.consumers.putAll(consumers);
    }

    @Override
    public Optional<Consumer> findById(long id) {
        return Optional.ofNullable(consumers.get(id));
    }

    @Override
    public List<Consumer> findAll() {
        return new ArrayList<>(consumers.values());
    }
}
