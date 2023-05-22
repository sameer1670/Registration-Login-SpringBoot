package com.example.registrationandlogin.service;

import com.example.registrationandlogin.config.UserAlreadyExistException;
import com.example.registrationandlogin.entities.Role;
import com.example.registrationandlogin.entities.User;
import com.example.registrationandlogin.repository.UserRepository;
import com.example.registrationandlogin.web.dto.LoginDto;
import com.example.registrationandlogin.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        try {
            User user = new User(
                    userRegistrationDto.getFirstName(),
                    userRegistrationDto.getLastName(),
                    userRegistrationDto.getEmail(),
                    userRegistrationDto.getPassword(),
                    // passwordEncoder.encode(userRegistrationDto.getPassword()),
                    Arrays.asList(new Role("ROLE_USER")));

            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserAlreadyExistException("User already exists!");
        }

    }

    @Override
    public boolean isAuthenticated(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getUserName());
        if(user != null) {
            return user.getPassword().equals(loginDto.getPassword());
        }
        return false;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if(user == null) {
//            throw new UsernameNotFoundException("Invalid username or password!");
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                mapRoleToAuthorities(user.getRoles())
//        );
//    }

//    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}
