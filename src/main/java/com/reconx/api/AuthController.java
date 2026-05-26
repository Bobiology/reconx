package com.reconx.api;

import com.reconx.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider provider;

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username
    ) {

        String token =
                provider.generateToken(username);

        return Map.of(
                "token",
                token
        );
    }
}
