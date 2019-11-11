package kz.zhabassov.project.controller;

import kz.zhabassov.project.entity.Player;
import kz.zhabassov.project.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Player> showAllPlayers() {
        return playerService.showAllPlayers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Player addNewPlayer(@RequestBody Player newPlayer) {
        return playerService.addPlayer(newPlayer);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player showPlayer(@PathVariable int id) {
        return playerService.showByID(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player updatePlayer(@PathVariable int id, @RequestBody Player updatePlayer) {
        return playerService.updatePlayer(updatePlayer);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeam(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
