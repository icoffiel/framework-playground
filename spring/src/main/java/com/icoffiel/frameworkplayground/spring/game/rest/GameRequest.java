package com.icoffiel.frameworkplayground.spring.game.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class GameRequest {
    @NotNull
    @Size(max = 255)
    private final String name;
    @NotNull
    private final LocalDate releaseDate;
    @NotNull
    @Min(1)
    private final Integer noOfPlayers;
    private final List<Integer> platforms;
}
