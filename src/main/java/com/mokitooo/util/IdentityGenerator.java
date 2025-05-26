package com.mokitooo.util;

import java.util.Iterator;

public class IdentityGenerator {
    private final IdentityIterator iterator = new IdentityIterator();

    public Long generate() {
        if (!iterator.hasNext()) throw new RuntimeException("Limit reached, no more elements can be generated");

        return iterator.next();
    }

    private static final class IdentityIterator implements Iterator<Long> {
        private long current;

        @Override
        public synchronized boolean hasNext() {
            return current < Long.MAX_VALUE;
        }

        @Override
        public synchronized Long next() {
            return current += 1;
        }
    }
}
