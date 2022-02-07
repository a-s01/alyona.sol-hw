package com.epam.spring.library.repository.impl.list;

import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.BaseRepository;
import com.epam.spring.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class UserRepositoryListImpl implements UserRepository {
    private final BaseRepository<User> repository;

    @Override
    public User getUser(String email) {
        return repository.get(email, User::getEmail);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAll();
    }

    @Override
    public User createUser(User user) {
        return repository.create(user, User::getEmail);
    }

    @Override
    public User updateUser(User user) {
        return repository.update(user, User::getEmail);
    }

    @Override
    public void deleteUser(String email) {
        repository.delete(email, User::getEmail);
    }
}
