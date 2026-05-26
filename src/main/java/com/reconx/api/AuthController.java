package com.reconx.api;

import com.reconx.security.jwt.JwtTokenProvider;
import com.reconx.security.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider provider;
    private final CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username
    ) {

        UserDetails user =
                userDetailsService
                        .loadUserByUsername(username);

        String accessToken =
                provider.generateAccessToken(user);

        String refreshToken =
                provider.generateRefreshToken(user);

        return Map.of(
                "accessToken",
                accessToken,
                "refreshToken",
                refreshToken
        );
    }
}
