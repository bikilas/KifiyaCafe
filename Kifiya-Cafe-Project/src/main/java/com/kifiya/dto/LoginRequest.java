// package com.kifiya.dto;

// import lombok.Data;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;

// @Data
// public class LoginRequest {
//     @NotBlank(message = "Email is required")
//     @Email(message = "Invalid email format")
//     private String email;
    
//     @NotBlank(message = "Password is required")
//     private String password;
// }
package com.kifiya.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "Password is required")
    private String password;
}