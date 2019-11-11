package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.PenaltyDao;
import kz.zhabassov.project.dao.PenaltyDaoTest;
import kz.zhabassov.project.dao.PlayerDao;
import kz.zhabassov.project.entity.Penalty;
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
import static org.mockito.Mockito.when;

public class PenaltyServiceTest {
    private PenaltyService penaltyService;
    @Mock
    PenaltyDao penaltyDao;
    List<Penalty> penalties;
    Penalty penalty1;
    Penalty penalty2;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        penaltyService = new PenaltyService();
        penaltyService.setPenaltyDao(penaltyDao);

        penalties = new ArrayList<>();

        penalty1 = new Penalty();
        penalty1.setPenalty("penalty 1");
        penalty1.setDescription("description of penalty 1");

        penalty2 = new Penalty();
        penalty2.setPenalty("penalty 2");
        penalty2.setDescription("description of penalty 2");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showAll() {
        penalties.add(penalty1);
        penalties.add(penalty2);
        when(penaltyDao.findAll()).thenReturn(penalties);
        List<Penalty> result = penaltyService.showAll();

        assertThat(result, is(equalTo(penalties)));
    }

    @Test
    public void updatePenalty() {
        penalty2.setDescription("update description of penalty 2");
        when(penaltyDao.update(penalty2)).thenReturn(penalty2);

        Penalty result = penaltyService.updatePenalty(penalty2);

        assertThat(result.getDescription(), is(equalToObject("update description of penalty 2")));
    }

    @Test
    public void insertPenalty() {
        when(penaltyDao.insert(penalty1)).thenReturn(penalty1);

        Penalty result = penaltyService.insertPenalty(penalty1);

        assertThat(result, is(equalTo(penalty1)));
    }
}