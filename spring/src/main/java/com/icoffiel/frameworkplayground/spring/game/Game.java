package com.icoffiel.frameworkplayground.spring.game;

import com.icoffiel.frameworkplayground.spring.platform.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private Integer noOfPlayers;

    @ManyToMany
    private Set<Platform> platforms;
}
