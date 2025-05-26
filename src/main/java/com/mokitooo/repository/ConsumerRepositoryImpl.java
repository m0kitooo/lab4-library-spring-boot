package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@NoArgsConstructor
public class ConsumerRepositoryImpl implements ConsumerRepository {
    private final Map<Long, Consumer> consumers = new HashMap<>();

    public ConsumerRepositoryImpl(Map<Long, Consumer> consumers) {
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
