package com.icoffiel.frameworkplayground.spring.spring.game.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class GameRequest {
    private final String name;
    private final LocalDate releaseDate;
    private final Integer noOfPlayers;
    private final List<Integer> platforms;
}
