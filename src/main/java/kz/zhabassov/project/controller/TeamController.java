package kz.zhabassov.project.controller;

import kz.zhabassov.project.entity.Team;
import kz.zhabassov.project.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Team> showAllTeams() {
        return teamService.showAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/new")
    public Team addNewTeam(@RequestBody Team newTeam) {
        return teamService.insert(newTeam);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{team}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team showTeam(@PathVariable String team) {
        return teamService.findByTeam(team);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{team}",  consumes=MediaType.APPLICATION_JSON_VALUE)
    public Team updateTeam(@PathVariable String team, @RequestBody Team updatedTeam) {
        return teamService.update(updatedTeam);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{team}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void showUpdateTeam(@PathVariable String team) {
        teamService.deleteTeam(team);
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }
}
