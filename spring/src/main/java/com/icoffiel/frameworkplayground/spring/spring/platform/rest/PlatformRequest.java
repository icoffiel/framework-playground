package com.icoffiel.frameworkplayground.spring.spring.platform.rest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlatformRequest {
    private String name;
    private LocalDate releaseDate;
    private String owner;
}
