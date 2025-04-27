package com.digital.school.dto;

import com.digital.school.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;

}
