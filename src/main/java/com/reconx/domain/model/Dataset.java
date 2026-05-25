package com.reconx.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Dataset {
    public UUID id;
    public String name;
    public String fileType;
    public String schemaJson;
    public LocalDateTime createdAt;
}
