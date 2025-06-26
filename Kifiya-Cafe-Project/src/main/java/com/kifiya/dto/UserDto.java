package com.kifiya.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<String> roles;
}
