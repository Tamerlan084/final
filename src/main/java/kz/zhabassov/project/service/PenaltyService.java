package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.PenaltyDao;
import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.entity.Penalty;
import kz.zhabassov.project.entity.Player;

import java.util.List;

public class PenaltyService {
    private PenaltyDao penaltyDao;
    //get all
    public List<Penalty> showAll(){
        return penaltyDao.findAll();
    }

    //update name description
    public Penalty updatePenalty(Penalty penalty){
        return penaltyDao.update(penalty);
    }
    //insert name description
    public Penalty insertPenalty(Penalty penalty){
        return penaltyDao.insert(penalty);
    }

    public void setPenaltyDao(PenaltyDao penaltyDao) {
        this.penaltyDao = penaltyDao;
    }
}
