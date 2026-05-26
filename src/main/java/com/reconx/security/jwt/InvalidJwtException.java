package com.reconx.security.jwt;

public class InvalidJwtException
        extends RuntimeException {

    public InvalidJwtException(
            String message
    ) {
        super(message);
    }
}
