package com.example.registrationandlogin.service;

import com.example.registrationandlogin.entities.User;
import com.example.registrationandlogin.web.dto.LoginDto;
import com.example.registrationandlogin.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);

    boolean isAuthenticated(LoginDto loginDto);
}
