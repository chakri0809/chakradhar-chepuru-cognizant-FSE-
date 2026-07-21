package com.cognizant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// Security configuration - controls which endpoints need login and which are public
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Disable CSRF for REST APIs
        http.csrf(csrf -> csrf.disable());

        // These endpoints are PUBLIC - no token needed
        // These endpoints are PROTECTED - need valid token
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/protected/**").authenticated()
                .anyRequest().permitAll()
        );

        // Disable basic auth for simplicity
        http.httpBasic(basic -> basic.disable());

        return http.build();
    }
}
