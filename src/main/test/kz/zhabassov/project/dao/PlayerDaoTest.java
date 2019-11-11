package kz.zhabassov.project.dao;

import kz.zhabassov.project.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;


public class PlayerDaoTest {
    private PlayerDao playerDao;
    private Player truePlayer;
    private Player newPlayer;
    private EmbeddedDatabase db;
//    ApplicationContext ctx;
//    NamedParameterJdbcTemplate template;
    @Before
    public void setUp() throws Exception {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:h2/V0_1__create_tables.sql")
                .addScript("classpath:h2/V0_2__insert_initial_data.sql")
                .build();
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
//        ctx = new ClassPathXmlApplicationContext("root-context.xml");
//        template = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
//        playerDao = (PlayerDao) ctx.getBean("playerDao");
        playerDao = new PlayerDao();
        playerDao.setNamedParameterJdbcTemplate(template);
        assertNotNull(playerDao);

        truePlayer = new Player();
        truePlayer.setPlayerId(1);
        truePlayer.setName("Nikita Kucherov");
        truePlayer.setTeam("Tampa Bay Lightning");
        truePlayer.setSkillLevel("master");
        truePlayer.setPosition("forward");

        newPlayer = new Player();
        newPlayer.setName("Yegor Korshkow");
        newPlayer.setTeam("Tampa Bay Lightning");
        newPlayer.setSkillLevel("junior");
        newPlayer.setPosition("forward");
    }


    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }

    @Test
    @Order(1)
    public void insert() {
        Player isInserted = playerDao.insert(newPlayer);
        assertTrue(isInserted != null);
    }

    @Test
    @Order(2)
    public void delete() {
        Player isInserted = playerDao.insert(newPlayer);
        assertTrue(isInserted != null);
        int isDeleted = playerDao.delete(isInserted.getPlayerId());
        assertTrue(isDeleted == isInserted.getPlayerId());

    }

    @Test
    @Order(3)
    public void update() {
        truePlayer.setSkillLevel("junior");
        Player isUpdatedFirst = playerDao.update(truePlayer);
        assertTrue(isUpdatedFirst!=null);
        truePlayer.setSkillLevel("master");
        Player isUpdatedSecond = playerDao.update(truePlayer);
        assertTrue(isUpdatedSecond!=null);
    }

    @Test
    @Order(4)
    public void findById() {
        Player player = playerDao.findById(1);
        assertTrue(truePlayer.getName().equals(player.getName()));
    }


    @Test
    @Order(5)
    public void findByName() {
        Player player = playerDao.findByName("Nikita Kucherov");
        assertTrue(truePlayer.getName().equals(player.getName()));
    }

    @Test
    @Order(6)
    public void findAll() {
        List<Player> players = playerDao.findAll();
        assertTrue(players.size() > 0);
    }


}