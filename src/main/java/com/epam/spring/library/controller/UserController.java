package com.epam.spring.library.controller;

import com.epam.spring.library.dto.UserDTO;
import com.epam.spring.library.dto.UserEditDTO;
import com.epam.spring.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDTO getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO createUser(@RequestBody UserEditDTO userEditDTO) {
        return userService.createUser(userEditDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDTO updateUser(@PathVariable String email,
                              @RequestBody UserEditDTO userEditDTO) {
        return userService.updateUser(email, userEditDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
}
