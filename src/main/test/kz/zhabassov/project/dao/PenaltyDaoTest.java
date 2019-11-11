package kz.zhabassov.project.dao;

import kz.zhabassov.project.entity.Penalty;
import kz.zhabassov.project.entity.Player;
import kz.zhabassov.project.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class PenaltyDaoTest {
    private PenaltyDao penaltyDao;
    private Penalty newPenalty;
    private EmbeddedDatabase db;

    @Before
    public void setUp() throws Exception {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:h2/V0_1__create_tables.sql")
                .addScript("classpath:h2/V0_2__insert_initial_data.sql")
                .build();
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        penaltyDao = new PenaltyDao();
        penaltyDao.setNamedParameterJdbcTemplate(template);
        assertNotNull(penaltyDao);

        newPenalty = new Penalty();
        newPenalty.setPenalty("test penalty");
        newPenalty.setDescription("test description");
    }

    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }

    @Test
    public void insert() {
        Penalty isInserted = penaltyDao.insert(newPenalty);
        assertTrue(isInserted != null);
    }

    @Test
    public void update() {
        newPenalty.setDescription("test desc");
        penaltyDao.insert(newPenalty);
        Penalty isUdated = penaltyDao.update(newPenalty);
        assertTrue("test desc".equals(isUdated.getDescription()));
    }

    @Test
    public void delete() {
        penaltyDao.insert(newPenalty);
        String penalty = penaltyDao.delete("test penalty");
        assertTrue("test penalty".equals(penalty));
    }

    @Test
    public void findAll() {
        List<Penalty> penalties = penaltyDao.findAll();
        assertTrue(penalties.size() > 0);
    }

    @Test
    public void findByPenalty() {
        penaltyDao.insert(newPenalty);
        Penalty penalty = penaltyDao.findByPenalty("test penalty");
        assertTrue("test description".equals(penalty.getDescription()));
    }
}