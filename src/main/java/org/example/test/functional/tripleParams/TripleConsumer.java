package org.example.test.functional.tripleParams;

@FunctionalInterface
interface TripleConsumer<T, U, K> {
    void accept(T t, U u, K k);
}
