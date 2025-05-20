package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@NoArgsConstructor
public class ConsumerRepository {
    private final Map<Long, Consumer> consumers = new HashMap<>();

    public ConsumerRepository(Map<Long, Consumer> consumers) {
        this.consumers.putAll(consumers);
    }

    public Optional<Consumer> findById(long id) {
        return Optional.ofNullable(consumers.get(id));
    }

    public List<Consumer> findAll() {
        return new ArrayList<>(consumers.values());
    }
}
