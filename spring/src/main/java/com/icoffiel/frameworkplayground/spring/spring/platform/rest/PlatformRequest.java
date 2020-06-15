package com.icoffiel.frameworkplayground.spring.spring.platform.rest;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlatformRequest {
    private String name;
    private LocalDateTime releaseDate;
    private String owner;
}
