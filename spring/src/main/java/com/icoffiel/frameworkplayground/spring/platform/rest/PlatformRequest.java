package com.icoffiel.frameworkplayground.spring.platform.rest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PlatformRequest {
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    @Size(max = 255)
    private String owner;
}
