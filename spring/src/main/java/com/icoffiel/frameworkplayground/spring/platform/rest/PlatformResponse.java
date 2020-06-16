package com.icoffiel.frameworkplayground.spring.platform.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PlatformResponse {
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private String owner;
}
