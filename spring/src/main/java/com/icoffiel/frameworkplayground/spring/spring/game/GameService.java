package com.icoffiel.frameworkplayground.spring.spring.game;

import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameRequest;
import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameResponse;
import com.icoffiel.frameworkplayground.spring.spring.platform.Platform;
import com.icoffiel.frameworkplayground.spring.spring.platform.PlatformRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository games;
    private final GameMapper gameMapper;
    private final PlatformRepository platforms;

    public GameService(
            GameRepository games,
            GameMapper gameMapper,
            PlatformRepository platforms
    ) {
        this.games = games;
        this.gameMapper = gameMapper;
        this.platforms = platforms;
    }

    public List<GameResponse> getAll() {
        return games
                .findAll()
                .stream()
                .map(gameMapper::gameToGameResponse)
                .collect(Collectors.toList());
    }

    public GameResponse save(GameRequest gameRequest) {
        Game game = gameMapper.gameRequestToGame(gameRequest);

        return gameMapper.gameToGameResponse(games.save(game));
    }

    public void delete(Integer id) {
        games.deleteById(id);
    }

    public GameResponse addGameToPlatform(Integer id, Integer platformId) {
        Game game = games
                .findById(id)
                .orElseThrow(() ->
                        new EmptyResultDataAccessException(
                                String.format("No %s entity with id %s exists!", "Game", id),
                                1
                        )
                );

        Platform platform = platforms
                .findById(platformId)
                .orElseThrow(() ->
                        new EmptyResultDataAccessException(
                                String.format("No %s entity with id %s exists!", "Platform", platformId),
                                1
                        )
                );

        game
                .getPlatforms()
                .add(platform);

        return gameMapper.gameToGameResponse(games.save(game));
    }

    public GameResponse removeGameFromPlatform(Integer id, Integer platformId) {
        Game game = games
                .findById(id)
                .orElseThrow(() ->
                        new EmptyResultDataAccessException(
                                String.format("No %s entity with id %s exists!", "Game", id),
                                1
                        )
                );

        Platform platform = game
                .getPlatforms()
                .stream()
                .filter(p -> p.getId().equals(platformId))
                .findFirst()
                .orElseThrow(() ->
                        new EmptyResultDataAccessException(
                                String.format("No %s entity with id %s exists on %s!", "Platform", platformId, "Game"),
                                1
                        )
                );

        game
                .getPlatforms()
                .remove(platform);

        return gameMapper.gameToGameResponse(games.save(game));
    }
}
