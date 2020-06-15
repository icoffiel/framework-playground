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

## Frameworks

* Spring: Java, Spring Data JPA

## TODO

* Spring Webflux: Java, Spring Data JPA
* Spring + JOOQ: Java, JOOQ
* Spring + Kotlin + Exposed
* Micronaut
* Quarkus
