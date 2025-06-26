package com.kifiya.dto;

import lombok.Data;
import java.util.List;

@Data
public class LoginResponse {
    private String token;
    private Long userId;
    private String name;
    private String email;
    private List<String> roles;
    
    public LoginResponse(String token, Long userId, String name, String email, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
}
