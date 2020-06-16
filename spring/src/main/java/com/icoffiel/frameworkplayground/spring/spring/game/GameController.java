package com.icoffiel.frameworkplayground.spring.spring.game;

import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameRequest;
import com.icoffiel.frameworkplayground.spring.spring.game.rest.GameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameResponse> index() {
        return gameService.getAll();
    }

    @PostMapping
    public GameResponse addGame(@RequestBody GameRequest gameRequest) {
        return gameService.save(gameRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Integer id) {
        gameService.delete(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
    
    @PutMapping("/{id}/platform/{platformId}")
    public GameResponse assignPlatformToGame(@PathVariable Integer id, @PathVariable Integer platformId) {
        return gameService.addGameToPlatform(id, platformId);
    }

    @DeleteMapping("/{id}/platform/{platformId}")
    public GameResponse removePlatformFromGame(@PathVariable Integer id, @PathVariable Integer platformId) {
        return gameService.removeGameFromPlatform(id, platformId);
    }
}
