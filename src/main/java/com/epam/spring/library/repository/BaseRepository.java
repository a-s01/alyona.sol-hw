package com.epam.spring.library.repository;

import java.util.List;
import java.util.function.Function;

public interface BaseRepository<T> {

    <R> T get(R key, Function<T, R> keyGetter);

    List<T> getAll();

    <R> List<T> getAll(R key, Function<T, R> keyGetter);

    <R> T create(T model, Function<T, R> keyGetter);

    <R> void delete(R key, Function<T, R> keyGetter);

    <R> T update(T model, Function<T, R> keyGetter);
}
