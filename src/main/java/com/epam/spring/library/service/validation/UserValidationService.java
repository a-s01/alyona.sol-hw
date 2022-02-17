package com.epam.spring.library.service.validation;

import com.epam.spring.library.model.User;

public interface UserValidationService {

    void validateDelete(User user);
}
