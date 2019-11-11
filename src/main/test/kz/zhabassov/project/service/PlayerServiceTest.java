package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.GameDao;
import kz.zhabassov.project.dao.PlayerDao;
import kz.zhabassov.project.dao.PlayerDaoTest;
import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {
    private PlayerService playerService;
    @Mock
    PlayerDao playerDao;
    List<Player> players;
    Player player1;
    Player player2;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        playerService = new PlayerService();
        playerService.setPlayerDao(playerDao);

        players = new ArrayList<>();

        player1 = new Player();
        player1.setName("Yegor Korshkow");
        player1.setTeam("Tampa Bay Lightning");
        player1.setSkillLevel("junior");
        player1.setPosition("forward");

        player2 = new Player();
        player2.setName("Alexandr Antropov");
        player2.setTeam("Tampa Bay Lightning");
        player2.setSkillLevel("master");
        player2.setPosition("forward");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showAllPlayers() {
        players.add(player1);
        players.add(player2);
        when(playerDao.findAll()).thenReturn(players);
        List<Player> result = playerService.showAllPlayers();

        assertThat(result, is(equalTo(players)));
    }

    @Test
    public void showFiveWithMaxPenalties() {
        players.add(player1);
        players.add(player2);
        when(playerDao.findFiveWithMaxPenalties()).thenReturn(players);
        List<Player> result = playerService.showFiveWithMaxPenalties();

        assertThat(result, is(equalTo(players)));
    }

    @Test
    public void addPlayer() {
        when(playerDao.insert(player1)).thenReturn(player1);

        Player result = playerService.addPlayer(player1);

        assertThat(result, is(equalTo(player1)));
    }

    @Test
    public void updatePlayer() {
        player1.setSkillLevel("master");
        when(playerDao.update(player1)).thenReturn(player1);

        Player result = playerService.updatePlayer(player1);

        assertThat(result.getSkillLevel(), is(equalToObject("master")));
    }

    @Test
    public void showByID() {
        when(playerDao.findById(1)).thenReturn(player1);

        Player result = playerService.showByID(1);

        assertThat(result, is(equalTo(player1)));
    }

    @Test
    public void deletePlayer() {
        when(playerDao.delete(1)).thenReturn(1);

        int result = playerService.deletePlayer(1);

        assertThat(result, is(equalToObject(1)));
    }

}