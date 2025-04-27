package com.digital.school.controller;

import com.digital.school.dto.RegisterRequest;
import com.digital.school.model.Role;
import com.digital.school.model.User;
import com.digital.school.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
         private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(
                registerRequest.getName(),
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getRole()
        );
    }
         @PostMapping("/login")
        public User login(@RequestParam String email, @RequestParam String password){
             return authenticationService.login(email,password);
         }

}
