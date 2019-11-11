package kz.zhabassov.project.dao;

import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.entity.Player;
import kz.zhabassov.project.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TeamDaoTest {
    private TeamDao teamDao;
    private EmbeddedDatabase db;
    private Team insertTeam;
    private PlayerDao playerDao;
    private Player newPlayer;

    @Before
    public void setUp() throws Exception {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:h2/V0_1__create_tables.sql")
                .addScript("classpath:h2/V0_2__insert_initial_data.sql")
                .build();
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        teamDao = new TeamDao();
        playerDao = new PlayerDao();
        teamDao.setNamedParameterJdbcTemplate(template);
        playerDao.setNamedParameterJdbcTemplate(template);
        insertTeam = new Team();
        insertTeam.setTeam("Lokomotiv");
        insertTeam.setCity("Yaraslavl");
        insertTeam.setCoach("Skabelka");
        newPlayer = new Player();
        newPlayer.setName("Yegor Korshkow");
//        newPlayer.setTeam("Lokomotiv");
        newPlayer.setSkillLevel("junior");
        newPlayer.setPosition("forward");
    }

    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }

    @Test
    public void insert() {
        Team insertedTeam = teamDao.insert(insertTeam);
        assertTrue(insertedTeam!=null);
    }

    @Test
    public void update() {
        Player player = playerDao.insert(newPlayer);
        insertTeam.setCaptain(player.getPlayerId());
        teamDao.insert(insertTeam);
        Team team = teamDao.update(insertTeam);
        assertTrue(player.getPlayerId() == team.getCaptain());
    }

    @Test
    public void delete() {
        Team isInserted = teamDao.insert(insertTeam);
        assertTrue(isInserted != null);
        String isDeleted = teamDao.delete(isInserted.getTeam());
        assertTrue("Lokomotiv".equals(isDeleted));
    }

    @Test
    public void findAll() {
        List<Team> teams = teamDao.findAll();
        assertTrue(teams.size() > 0);

    }

    @Test
    public void findFirstFiveWithMaxScore() {
        List<Team> teams = teamDao.findFirstFiveWithMaxScore();
        assertTrue(teams.get(0).getTeam().equals("Tampa Bay Lightning"));
    }
}