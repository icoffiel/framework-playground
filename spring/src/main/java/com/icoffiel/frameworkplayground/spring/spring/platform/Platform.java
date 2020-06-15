package com.icoffiel.frameworkplayground.spring.spring.platform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platform {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private LocalDateTime releaseDate;
    private String owner;
}
