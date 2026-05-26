package com.reconx.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final SecretKey key;

    public JwtTokenProvider(
            @Value("${jwt.secret}")
            String secret
    ) {

        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateAccessToken(String userName, String role) {

        return Jwts.builder()

                .subject(userName)

                .claim("role", role)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 30
                        )
                )

                .signWith(key, SignatureAlgorithm.HS256)

                .compact();
    }

    public String generateRefreshToken(
            UserDetails user
    ) {

        return Jwts.builder()

                .subject(user.getUsername())

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000L * 60 * 60 * 24 * 7
                        )
                )

                .signWith(key, SignatureAlgorithm.HS256)

                .compact();
    }

    public Claims parseClaims(String token) {

        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }catch (Exception e) {
            throw new InvalidJwtException("Invalid JWT token Or Expired Token: "+e.getMessage());
        }
    }

    public boolean isTokenValid(
            String token
    ) {

        try {

            Claims claims =
                    parseClaims(token);

            return claims
                    .getExpiration()
                    .after(new Date());

        } catch (JwtException e) {

            return false;
        }
    }

    public String getUsername(
            String token
    ) {

        return parseClaims(token)
                .getSubject();
    }

    public List<String> getRoles(
            String token
    ) {

        return parseClaims(token)
                .get("roles", List.class);
    }
}