package com.example.registrationandlogin.web;

import com.example.registrationandlogin.service.UserService;
import com.example.registrationandlogin.web.dto.LoginDto;
import com.example.registrationandlogin.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ModelAttribute("userLogin")
    public LoginDto loginDto() {
        return new LoginDto();
    }

    @PostMapping("/login")
    public String registerUserAccount(@ModelAttribute("userLogin") LoginDto loginDto) {
        boolean isAuthenticated = userService.isAuthenticated(loginDto);
        if(isAuthenticated) {
            return "redirect:/home";
        }
        return "redirect:/login?error";
    }
}
