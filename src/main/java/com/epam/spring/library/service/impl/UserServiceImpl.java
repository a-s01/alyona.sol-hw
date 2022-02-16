package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.mapper.UserMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.PasswordService;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final Language defaultLanguage;
    private final PasswordService passwordService;

    @Override
    public UserDTO getUser(String email) {
        User user = repository.getUser(email);
        return mapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        return mapper.toDTO(
                repository.save(setUserDefaults(mapper.toUser(userDTO))));
    }

    private User setUserDefaults(User user) {
        if (user.getPreferredLanguage() == null) {
            user.setPreferredLanguage(defaultLanguage);
        }

        user.setSalt(passwordService.generateSalt());
        user.setPassword(
                passwordService.hash(user.getPassword(), user.getSalt()));
        return user;
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDTO) {
        User toUpdate = repository.getUser(email);
        mapper.updateUser(userDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }

    @Override
    public void deleteUser(String email) {
        repository.deleteUser(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.toDTO(repository.findAll());
    }
}
