package com.epam.spring.library.service.impl;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.mapper.UserMapper;
import com.epam.spring.library.model.Language;
import com.epam.spring.library.model.User;
import com.epam.spring.library.repository.UserRepository;
import com.epam.spring.library.service.PasswordService;
import com.epam.spring.library.service.UserService;
import com.epam.spring.library.service.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.epam.spring.library.model.User.State.DELETED;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final Language defaultLanguage;
    private final PasswordService passwordService;
    private final UserValidationService validator;

    @Override
    public UserDTO getUser(String email) {
        User user = repository.getActiveUser(email);
        return mapper.toDTO(user);
    }

    @Override
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
        User toUpdate = repository.getActiveUser(email);
        mapper.updateUser(userDTO, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }

    @Override
    public void deleteUser(String email) {
        User user = repository.getActiveUser(email);
        validator.validateDelete(user);
        user.setState(DELETED);
        repository.save(user);
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable page) {
        return repository.findTop10ByStateNot(DELETED, page).map(mapper::toDTO);
    }
}
