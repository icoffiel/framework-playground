package com.icoffiel.frameworkplayground.spring.spring.platform.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PlatformResponse {
    private Integer id;
    private String name;
    private LocalDateTime releaseDate;
    private String owner;
}
