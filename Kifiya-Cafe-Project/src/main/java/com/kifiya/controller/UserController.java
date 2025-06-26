 package com.kifiya.controller;

 import com.kifiya.dto.UserDto;
 import com.kifiya.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

 @RestController
 @RequestMapping("/api/users")
 public class UserController {
    
     @Autowired
     private UserService userService;
    
     // Get all users (admin only)
     @GetMapping
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<List<UserDto>> getAllUsers() {
         List<UserDto> users = userService.getAllUsers();
         return ResponseEntity.ok(users);
     }
    
     // Get user by ID
     @GetMapping("/{id}")
     public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
         UserDto user = userService.getUserById(id);
         return ResponseEntity.ok(user);
     }
    
     // Create new user
     @PostMapping
     public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
         UserDto createdUser = userService.createUser(userDto);
         return ResponseEntity.ok(createdUser);
     }
    
     // Update user
     @PutMapping("/{id}")
     public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
         UserDto updatedUser = userService.updateUser(id, userDto);
         return ResponseEntity.ok(updatedUser);
     }
    
     // Delete user
     @DeleteMapping("/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
         return ResponseEntity.noContent().build();
     }
 }
