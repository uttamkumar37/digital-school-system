package com.digital.school.controller;

import com.digital.school.model.Role;
import com.digital.school.model.User;
import com.digital.school.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
         private final AuthenticationService authenticationService;
         @PostMapping("/register")
         public User register(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam Role role){
             return authenticationService.register(name,email,password,role);
         }
         @PostMapping("/login")
        public User login(@RequestParam String email, @RequestParam String password){
             return authenticationService.login(email,password);
         }

}
