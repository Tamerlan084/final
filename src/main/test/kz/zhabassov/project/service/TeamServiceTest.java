package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.PlayerDao;
import kz.zhabassov.project.dao.TeamDao;
import kz.zhabassov.project.entity.Player;
import kz.zhabassov.project.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TeamServiceTest {
    private TeamService teamService;
    @Mock
    TeamDao teamDao;
    List<Team> teams;
    Team team1;
    Team team2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        teamService = new TeamService();
        teamService.setTeamDao(teamDao);

        teams = new ArrayList<>();

        team1 = new Team();
        team1.setTeam("Komanda G");
        team1.setCity("FM");
        team1.setCoach("James Jonson");
        team1.setCaptain(1);

        team2 = new Team();
        team1.setTeam("Komanda M");
        team1.setCity("F");
        team1.setCoach("Jonson James");
        team1.setCaptain(2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showAll() {
        teams.add(team1);
        teams.add(team1);
        when(teamDao.findAll()).thenReturn(teams);
        List<Team> result = teamService.showAll();

        assertThat(result, is(equalTo(teams)));

    }

    @Test
    public void showFirstFive() {
        teams.add(team1);
        teams.add(team1);
        when(teamDao.findFirstFiveWithMaxScore()).thenReturn(teams);
        List<Team> result = teamService.showFirstFive();

        assertThat(result, is(equalTo(teams)));
    }

    @Test
    public void update() {
        team1.setCoach("Mr.Jonson");
        when(teamService.update(team1)).thenReturn(team1);

        Team result = teamService.update(team1);

        assertThat(result.getCoach(), is(equalToObject("Mr.Jonson")));
    }

    @Test
    public void insert() {
        when(teamDao.insert(team1)).thenReturn(team1);

        Team result = teamService.insert(team1);

        assertThat(result, is(equalTo(team1)));
    }

    @Test
    public void findByTeam() {
        when(teamDao.findByTeam("Komanda G")).thenReturn(team1);

        Team result = teamService.findByTeam("Komanda G");

        assertThat(result, is(equalTo(team1)));
    }

    @Test
    public void deleteTeam() {
        when(teamService.deleteTeam("Komanda G")).thenReturn("Komanda G");

        String result = teamService.deleteTeam("Komanda G");

        assertThat(result, is(equalToObject("Komanda G")));

    }
}