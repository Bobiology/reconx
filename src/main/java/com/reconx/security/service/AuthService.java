package com.reconx.security.service;

import com.reconx.security.jwt.JwtTokenProvider;
import com.reconx.security.model.User;
import com.reconx.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtService;

    public String register(User newUser) {
        User user = User.builder()
                .username(newUser.getUsername())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .email(newUser.getEmail())
                .role(com.reconx.security.model.Role.USER)
                .build();

        User createdUser = userRepository.save(user); // will be enhanced to check for existing username/email and handle exceptions
        return "User registered successfully";
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateAccessToken(user.getUsername(), user.getRole().name());
    }
}