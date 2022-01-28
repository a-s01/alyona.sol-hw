package com.epam.spring.library.repository;

import com.epam.spring.library.model.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);
    User getUser(String email);
    User updateUser(User user);
    void deleteUser(String email);
    List<User> getAllUsers();
}
