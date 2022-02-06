package com.epam.spring.library.service;

import com.epam.spring.library.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    void deleteUser(String email);

    List<UserDTO> getAllUsers();
}
