package com.kifiya.repository;

import com.kifiya.model.PasswordResetToken;
import com.kifiya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    Optional<PasswordResetToken> findByUserId(Long userId);
    void deleteByUserId(Long userId);
    void deleteByUser(User user);
    void deleteAllByExpiryDateLessThan(LocalDateTime expiryDate);
}
