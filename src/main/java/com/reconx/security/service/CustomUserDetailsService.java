package com.reconx.security.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {

        return User.builder()
                .username(username)
                .password(
                        "$2a$10$DowJonesIndexExampleHash"
                )
                .authorities(
                        List.of(
                                () -> "ROLE_ADMIN"
                        )
                )
                .build();
    }
}
