package com.epam.spring.library.controller;

import com.epam.spring.library.api.UserAPI;
import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserAPI {
    private final UserService service;

    @Override
    public UserDTO getUser(@PathVariable String email) {
        return service.getUser(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @Override
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return service.createUser(userDTO);
    }

    @Override
    public UserDTO updateUser(@PathVariable String email,
                              @RequestBody UserDTO userDTO) {
        return service.updateUser(email, userDTO);
    }

    @Override
    public void deleteUser(@PathVariable String email) {
        service.deleteUser(email);
    }
}
