package com.kifiya.service;

import com.kifiya.model.PasswordResetToken;
import com.kifiya.model.User;
import com.kifiya.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetTokenService {

   private final PasswordResetTokenRepository tokenRepository;

   @Value("${app.password.reset.token.expiration.minutes:60}")
   private long expirationMinutes;

   public PasswordResetTokenService(PasswordResetTokenRepository tokenRepository) {
       this.tokenRepository = tokenRepository;
   }

   @Transactional
   public PasswordResetToken createPasswordResetTokenForUser(User user) {
       tokenRepository.deleteByUser(user); // Invalidate any existing tokens for the user

       String token = UUID.randomUUID().toString();
       LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(expirationMinutes);
       PasswordResetToken myToken = new PasswordResetToken(token, user, expiryDate);
       return tokenRepository.save(myToken);
   }

   public PasswordResetToken validatePasswordResetToken(String token) {
       return tokenRepository.findByToken(token)
               .orElseThrow(() -> new RuntimeException("Invalid password reset token."));
   }

   @Transactional
   public void deleteToken(PasswordResetToken token) {
       tokenRepository.delete(token);
   }
}