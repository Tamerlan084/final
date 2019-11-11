package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.GameDao;
import kz.zhabassov.project.entity.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameServiceTest {
    private GameService gameService;
    @Mock
    GameDao gameDao;
    List<Game> games;
    Game game1;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        gameService = new GameService();
        gameService.setGameDao(gameDao);
        games = new ArrayList<>();
        game1 = new Game();
        Date date = new Date();
        game1.setGameId(1);
        game1.setGuestScore(1);
        game1.setHostTeam("Barys");
        game1.setGuestTeam("Admiral");
        game1.setHostScore(3);
        game1.setDate(date);
        games.add(game1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showLastFiveGames() {

        when(gameDao.findLastFive()).thenReturn(games);
        List<Game> result = gameService.showLastFiveGames();

        assertThat(result, is(equalTo(games)));
    }

    @Test
    public void showAllGames() {
        when(gameDao.findAll()).thenReturn(games);
        List<Game> result = gameService.showAllGames();

        assertThat(result, is(equalTo(games)));
    }

    @Test
    public void updateScore() {
        game1.setHostScore(4);
        when(gameDao.update(game1)).thenReturn(game1);

        Game result = gameService.updateScore(game1);

        assertThat(result.getHostScore(), is(equalToObject(game1.getHostScore())));
    }

    @Test
    public void addGame() {
        when(gameDao.insert(game1)).thenReturn(game1);

        Game result = gameService.addGame(game1);

        assertThat(result, is(equalTo(game1)));
    }

    @Test
    public void showByID() {
        when(gameDao.findById(1)).thenReturn(game1);

        Game result = gameService.showByID(1);

        assertThat(result, is(equalTo(game1)));
    }


    @Test
    public void deleteGame() {
        when(gameDao.delete(1)).thenReturn(1);

        int result = gameService.deleteGame(1);

        assertThat(result, is(equalToObject(1)));
    }
}