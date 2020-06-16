# Framework Playground

Testing out various Frameworks

## Scenario

A REST based API that can store information about gaming systems.

## Domain

### Game

Contains the following:

* Name: String, 255 chars
* Release Date: Date
* Number of Players, Integer
* Platform (Many to One)

### Platform

Contains the following:

* Name: String, 255 chars
* Release Date:  Date
* Owner: String 255 chars

### Schema

The following `schema.sql` file will be used to create the tables above:

```sql
CREATE TABLE IF NOT EXISTS platform (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    owner VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS game (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    number_of_players INT NOT NULL
);

CREATE TABLE IF NOT EXISTS game_platforms (
    game_id INT,
    platform_id INT,
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (platform_id) REFERENCES platform(id)
);
```

## Frameworks

* Spring: Java, Spring Data JPA

## TODO

* Spring Webflux: Java, Spring Data JPA
* Spring + JOOQ: Java, JOOQ
* Spring + Kotlin + Exposed
* Micronaut
* Quarkus
