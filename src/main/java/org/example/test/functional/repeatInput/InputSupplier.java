package org.example.test.functional.repeatInput;

@FunctionalInterface
public interface InputSupplier<T> {
    T get() throws Exception;
}