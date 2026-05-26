package com.reconx.domain.security;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {

    private UUID id;
    private String username;
    private String password;
    private String role;
    private String tenantId;

}
