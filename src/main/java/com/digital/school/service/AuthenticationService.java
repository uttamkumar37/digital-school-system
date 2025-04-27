package com.digital.school.service;

import com.digital.school.model.Role;
import com.digital.school.model.User;
import com.digital.school.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User register(String name, String email, String password, Role role){
        if(userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("User Already Exist with email: "+ email);
        }
        User user = User.builder().name(name).email(email).password(passwordEncoder.encode(password)).build();
        return userRepository.save(user);
    }
    public User login(String email,String password){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Invalid Email or password"));
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid Email or Password");
        }
        return user;
    }
}
