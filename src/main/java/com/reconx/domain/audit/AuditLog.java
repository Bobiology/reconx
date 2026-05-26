package com.reconx.domain.audit;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditLog {

    private String username;

    private String action;

    private LocalDateTime timestamp;
}
