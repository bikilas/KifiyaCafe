package com.kifiya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import jakarta.servlet.http.HttpServletRequest; // Correct import for HttpServletRequest

import java.util.Arrays;
import java.util.Collections; // For Collections.singletonList

@Configuration
@EnableWebSecurity
public class AppConfig {

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object for configuration
     * @return the configured SecurityFilterChain
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize -> Authorize
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Admin access
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // User access
                        .requestMatchers("/api/public/**", "/auth/**").permitAll() // Publicly accessible endpoints (e.g., login, registration)
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class) // Assuming JwtTokenValidator is correctly defined
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // Use the corsConfigurationSource bean

        return http.build();
    }

    /**
     * Configures the CORS (Cross-Origin Resource Sharing) settings for the application.
     *
     * @return a CorsConfigurationSource bean
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cfg = new CorsConfiguration();
                cfg.setAllowedOrigins(Arrays.asList(
                        "frontendlink", // Replace with your actual frontend URL
                        "https://localhost:3000", // Example for local development
                        "http://localhost:3000"
                ));
                cfg.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
                cfg.setAllowCredentials(true); // Allow credentials (e.g., cookies, authorization headers)
                cfg.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers
                cfg.setExposedHeaders(Arrays.asList("Authorization", "Content-Type")); // Expose specific headers
                cfg.setMaxAge(3600L); // Cache preflight requests for 1 hour
                return cfg;
            }
        };
    }

    /**
     * Provides a PasswordEncoder bean for password encryption.
     *
     * @return a PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10); // Strength 10 is a good default, 12 is also fine but can be slower
    }
}