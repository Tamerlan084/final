package kz.zhabassov.project.dao;

import kz.zhabassov.project.entity.PenaltyOfPlayerInGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class PenaltyOfPlayerInGameDaoTest {
    private PenaltyOfPlayerInGameDao penaltyOfPlayerInGameDao;
    private PenaltyOfPlayerInGame penaltyOfPlayerInGame;
    private EmbeddedDatabase db;

    @Before
    public void setUp() throws Exception { db = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:h2/V0_1__create_tables.sql")
            .addScript("classpath:h2/V0_2__insert_initial_data.sql")
            .build();
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        penaltyOfPlayerInGameDao = new PenaltyOfPlayerInGameDao();
        penaltyOfPlayerInGameDao.setNamedParameterJdbcTemplate(template);
        assertNotNull(penaltyOfPlayerInGameDao);

        penaltyOfPlayerInGame = new PenaltyOfPlayerInGame();
        penaltyOfPlayerInGame.setPenalty("butt ending");
        penaltyOfPlayerInGame.setPlayerId(1);
        penaltyOfPlayerInGame.setPlayerName("Jon Cooper");
        penaltyOfPlayerInGame.setGame_id(2);

    }

    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }

    @Test
    public void insert() {
       PenaltyOfPlayerInGame isInserted = penaltyOfPlayerInGameDao.insert(penaltyOfPlayerInGame);
       assertTrue("Jon Cooper".equals(isInserted.getPlayerName()));
       assertTrue(2 == isInserted.getGame_id());
       assertTrue("butt ending".equals(isInserted.getPenalty()));
    }

    @Test
    public void update() {
        PenaltyOfPlayerInGame inserted = penaltyOfPlayerInGameDao.insert(penaltyOfPlayerInGame);
        inserted.setPenalty("checking from behind");
        PenaltyOfPlayerInGame isUpdated = penaltyOfPlayerInGameDao.update(inserted);
        assertTrue("Jon Cooper".equals(isUpdated.getPlayerName()));
        assertTrue(2 == isUpdated.getGame_id());
        assertTrue("checking from behind".equals(isUpdated.getPenalty()));

    }

    @Test
    public void delete() {
        PenaltyOfPlayerInGame inserted = penaltyOfPlayerInGameDao.insert(penaltyOfPlayerInGame);
        int id = penaltyOfPlayerInGameDao.delete(inserted.getPenaltyOfPlayerInGameId());
        assertTrue(id == inserted.getPenaltyOfPlayerInGameId());
    }

    @Test
    public void findAll() {
        List<PenaltyOfPlayerInGame> penaltyOfPlayerInGames = penaltyOfPlayerInGameDao.findAll();
        assertTrue(penaltyOfPlayerInGames.size() > 0);
    }
}