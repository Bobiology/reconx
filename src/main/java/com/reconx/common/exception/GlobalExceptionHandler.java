package com.reconx.common.exception;

import com.reconx.security.jwt.InvalidJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidJwtException.class)
    public ResponseEntity<?> handleJwt(
            InvalidJwtException ex
    ) {

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(
                        Map.of(
                                "error",
                                ex.getMessage()
                        )
                );
    }
}
