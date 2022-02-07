package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.exception.EntityAlreadyExistsException;
import com.epam.spring.library.exception.EntityNotFoundException;
import com.epam.spring.library.model.Entity;
import com.epam.spring.library.repository.BaseRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ListRepositoryImpl<T extends Entity> implements BaseRepository<T> {
    private final List<T> list = new ArrayList<>();

    public <R> T get(R key, Function<T, R> keyGetter) {
        return list
                .stream()
                .filter(t -> keyGetter.apply(t).equals(key))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(
                        "Entity with key " + key + " is not found!"));
    }

    public List<T> getAll() {
        return new ArrayList<>(list);
    }

    public <R> List<T> getAll(R key, Function<T, R> keyGetter) {
        return list
                .stream()
                .filter(t -> keyGetter.apply(t).equals(key))
                .collect(Collectors.toList());
    }

    public <R> T create(T model, Function<T, R> keyGetter) {
        final R key = keyGetter.apply(model);
        Optional<T> existed = list
                .stream()
                .filter(t -> keyGetter.apply(t).equals(key))
                .findFirst();

        if (existed.isPresent()) {
            throw new EntityAlreadyExistsException(
                    model.getClass().getSimpleName() + "with " + key
                    + " key already exists");
        }

        model.setId(list.size() + 1);
        list.add(model);
        return model;
    }

    public <R> T update(T model, Function<T, R> keyGetter) {
        if (isDeleted(model, keyGetter)) {
            list.add(model);
        } else {
            throw new EntityNotFoundException(
                    model.getClass().getSimpleName() + " is not found!");
        }
        return model;
    }

    private <R> boolean isDeleted(T model, Function<T, R> keyGetter) {
        return list.removeIf(
                t -> keyGetter.apply(t).equals(keyGetter.apply(model)));
    }

    public <R> void delete(R key, Function<T, R> keyGetter) {
        list.removeIf(t -> keyGetter.apply(t).equals(key));
    }
}
