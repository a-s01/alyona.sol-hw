package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;
import com.epam.spring.library.dto.mapper.UserMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final Language defaultLanguage;

    @Override
    public UserDTO getUser(String email) {
        log.info("get user {}", email);
        User user = repository.getUser(email);
        return mapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserEditDTO userEditDTO) {
        log.info("create user {}", userEditDTO);
        User newUser = setUserDefaults(mapper.createUser(userEditDTO));
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
    public UserDTO updateUser(String email, UserEditDTO userEditDTO) {
        log.info("update user {} with new info {}", email, userEditDTO);
        User toUpdate = repository.getUser(email);
        mapper.updateUser(userEditDTO, toUpdate);
        return mapper.toDTO(repository.updateUser(toUpdate));
    }

    @Override
    public void deleteUser(String email) {
        log.info("delete user {}", email);
        repository.deleteUser(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("get all users");
        return mapper.toDTO(repository.getAllUsers());
    }
}
