package com.example.registrationandlogin.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    private String handleUserAlreadyExistsException(UserAlreadyExistException userAlreadyExistException) {
        return "redirect:/registration?error="+userAlreadyExistException.getMessage();
    }
}
