package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.mapper.UserMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final Language defaultLanguage;

    @Override
    public UserDTO getUser(String email) {
        User user = repository.getUser(email);
        return mapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User newUser = setUserDefaults(mapper.toUser(userDTO));
        User user = repository.createUser(newUser);
        return mapper.toDTO(user);
    }

    private User setUserDefaults(User user) {
        if (user.getPreferredLanguage() == null) {
            user.setPreferredLanguage(defaultLanguage);
        }

        return user;
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDTO) {
        User toUpdate = repository.getUser(email);
        mapper.updateUser(userDTO, toUpdate);
        return mapper.toDTO(repository.updateUser(toUpdate));
    }

    @Override
    public void deleteUser(String email) {
        repository.deleteUser(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.toDTO(repository.getAllUsers());
    }
}
