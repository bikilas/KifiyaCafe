package com.kifiya.repository;

import com.kifiya.model.User; // Imports your User entity
import org.springframework.data.jpa.repository.JpaRepository; // Core Spring Data JPA interface
import org.springframework.stereotype.Repository; // Annotation to mark it as a repository component

import java.util.Optional; // Used for findByEmail to handle cases where a user might not be found

@Repository // 1. Marks this interface as a Spring Data JPA repository component
public interface UserRepository extends JpaRepository<User, Long> { // 2. Extends JpaRepository

    // 3. Custom Query Methods (Derived Query Methods)
    Optional<User> findByEmail(String email); // Example: Find a user by their email address
    boolean existsByEmail(String email); // Example: Check if a user with a given email exists
    Optional<User> findByUsername(String username);

}