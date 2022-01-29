package com.epam.spring.library.service;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    UserDTO createUser(UserEditDTO userDTO);

    UserDTO updateUser(String email, UserEditDTO userDTO);

    void deleteUser(String email);

    List<UserDTO> getAllUsers();
}
