package com.icoffiel.frameworkplayground.spring.spring.game;

import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameRequest;
import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameResponse;
import com.icoffiel.frameworkplayground.spring.spring.platform.PlatformMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class GameMapper {
    private final PlatformMapper platformMapper;

    public GameMapper(PlatformMapper platformMapper) {
        this.platformMapper = platformMapper;
    }

    public GameResponse gameToGameResponse(Game game) {
        return new GameResponse(
                game.getId(),
                game.getName(),
                game.getReleaseDate(),
                platformMapper.platformsToPlatformResponses(game.getPlatforms())
        );
    }

    public Game gameRequestToGame(GameRequest gameRequest) {
        return new Game(
                null,
                gameRequest.getName(),
                gameRequest.getReleaseDate(),
                gameRequest.getNoOfPlayers(),
                new HashSet<>()
        );
    }
}
