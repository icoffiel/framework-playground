package com.icoffiel.frameworkplayground.spring.platform;

import com.icoffiel.frameworkplayground.spring.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platform {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private String owner;

    @ManyToMany(mappedBy = "platforms")
    private List<Game> games;
}
