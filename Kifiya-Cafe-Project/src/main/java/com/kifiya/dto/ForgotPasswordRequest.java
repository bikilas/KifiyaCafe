// package com.kifiya.dto;

// import lombok.Data;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;

// @Data
// public class ForgotPasswordRequest {
//     @NotBlank(message = "Email is required")
//     @Email(message = "Invalid email format")
//     private String email;
// }
package com.kifiya.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class ForgotPasswordRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
}