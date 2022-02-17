package com.epam.spring.library.service;

import com.epam.spring.library.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO getUser(String email);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    void deleteUser(String email);

    Page<UserDTO> getAllUsers(Pageable page);
}
