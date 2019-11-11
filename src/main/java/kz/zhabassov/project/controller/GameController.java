package kz.zhabassov.project.controller;

import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> showAllGames() {
        return gameService.showAllGames();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Game openFormAddNewGame(@RequestBody Game newGame) {
        return gameService.addGame(newGame);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Game updateTeam(@PathVariable int id, @RequestBody Game updatedGame) {
        return gameService.updateScore(updatedGame);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
