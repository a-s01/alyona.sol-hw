package com.epam.spring.library.service;

public interface PasswordService {

    String hash(String password, String salt);

    String generateSalt();
}
