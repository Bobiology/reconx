package com.reconx.security.filter;

import com.reconx.security.jwt.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtTokenProvider provider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String auth =
                request.getHeader("Authorization");

        if (auth != null &&
                auth.startsWith("Bearer ")) {

            String token =
                    auth.substring(7);

            if (!provider.isTokenValid(token)) {

                throw new InvalidJwtException(
                        "JWT token expired or invalid"
                );
            }

            String username =
                    provider.getUsername(token);

            List<SimpleGrantedAuthority>
                    authorities = Optional.ofNullable(
                    provider.getRoles(token)).orElse(List.of())
                            .stream()
                            .map(SimpleGrantedAuthority::new)
                            .toList();

            UsernamePasswordAuthenticationToken
                    authentication =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            authorities
                    );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}