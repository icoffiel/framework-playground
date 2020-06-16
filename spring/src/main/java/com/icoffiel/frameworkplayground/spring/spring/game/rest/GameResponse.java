package com.icoffiel.frameworkplayground.spring.spring.game.rest;

import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class GameResponse {
    private final Integer id;
    private final String name;
    private final LocalDate releaseDate;
    private final List<PlatformResponse> platforms;
}
