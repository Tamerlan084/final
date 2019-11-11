package kz.zhabassov.project.controller;

import kz.zhabassov.project.service.GameService;
import kz.zhabassov.project.service.PlayerService;
import kz.zhabassov.project.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = {"/", "/home"})
    public Map showHomePage() {
        Map<String, Object> items = new HashMap<>();

        items.put("teams", teamService.showFirstFive());
        items.put("players", playerService.showFiveWithMaxPenalties());
        items.put("games", gameService.showLastFiveGames());
        return items;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }
}
