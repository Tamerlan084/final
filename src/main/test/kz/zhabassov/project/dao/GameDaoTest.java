package kz.zhabassov.project.dao;

import kz.zhabassov.project.entity.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GameDaoTest {
    private GameDao gameDao;
    private EmbeddedDatabase db;
    private Game insertGame;
    private Date date;
    @Before
    public void setUp() throws Exception {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:h2/V0_1__create_tables.sql")
                .addScript("classpath:h2/V0_2__insert_initial_data.sql")
                .build();
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        gameDao = new GameDao();
        gameDao.setNamedParameterJdbcTemplate(template);
        insertGame = new Game();
        date = new Date();
        insertGame.setDate(date);
        insertGame.setGuestScore(0);
        insertGame.setHostScore(1);
        insertGame.setGuestTeam("Tampa Bay Lightning");
        insertGame.setHostTeam("Washington Capitals");

    }

    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }

    @Test
    public void insert() {
        Game insertedGame = gameDao.insert(insertGame);
        assertTrue(insertedGame!=null);
    }

    @Test
    public void update() {
        Game insertedGame = gameDao.insert(insertGame);
        insertGame.setGuestScore(1);
        Game isUpdatedFirst = gameDao.update(insertGame);
        assertTrue(isUpdatedFirst!=null);
    }

    @Test
    public void delete() {
        Game isInserted = gameDao.insert(insertGame);
        assertTrue(isInserted != null);
        int isDeleted = gameDao.delete(isInserted.getGameId());
        assertTrue(isDeleted == isInserted.getGameId());
    }

    @Test
    public void findAll() {
        List<Game> games = gameDao.findAll();
        assertTrue(games.size() > 0);
    }

    @Test
    public void findLastFive() {
        List<Game> games = gameDao.findLastFive();
        assertTrue(games.size() <= 5);
        assertTrue(games.get(0).getDate().after(games.get(1).getDate()));
    }


    @Test
    public void findById() {
        Game isInserted = gameDao.insert(insertGame);
        Game game = gameDao.findById(isInserted.getGameId());
        assertTrue("Tampa Bay Lightning".equals(game.getGuestTeam())
                &&"Washington Capitals".equals(game.getHostTeam()));
    }

}