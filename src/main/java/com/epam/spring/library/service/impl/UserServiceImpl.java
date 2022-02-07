package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;
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
class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final Language defaultLanguage;

    @Override
    public UserDTO getUser(String email) {
        User user = repository.getUser(email);
        return mapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserEditDTO userEditDTO) {
        return mapper.toDTO(repository.createUser(
                setUserDefaults(mapper.createUser(userEditDTO))));
    }

    private User setUserDefaults(User user) {
        if (user.getPreferredLanguage() == null) {
            user.setPreferredLanguage(defaultLanguage);
        }

        return user;
    }

    @Override
    public UserDTO updateUser(String email, UserEditDTO userEditDTO) {
        User toUpdate = repository.getUser(email);
        mapper.updateUser(userEditDTO, toUpdate);
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
