package com.epam.spring.library.repository.impl;

import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryListImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return list.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(list);
    }

    @Override
    public User createUser(User user) {
        Optional<User> existed = list.stream()
                                    .filter(u -> u.getEmail()
                                    .equals(user.getEmail()))
                                    .findFirst();

        if (existed.isPresent()) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }

        list.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        boolean isDeleted = list.removeIf(u -> u.getEmail().equals(user.getEmail()));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        list.removeIf(user -> user.getEmail().equals(email));
    }
}
