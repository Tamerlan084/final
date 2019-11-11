package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.PlayerDao;
import kz.zhabassov.project.entity.Player;

import java.util.List;

public class PlayerService {
    private PlayerDao playerDao;
    //get all
    public List<Player> showAllPlayers(){
        return playerDao.findAll();
    }

    //get five first with max penalties
    public List<Player> showFiveWithMaxPenalties(){
        return playerDao.findFiveWithMaxPenalties();
    }

    //add name team, position, skill level
    public Player addPlayer(Player player){
        return playerDao.insert(player);
    }

    //update name, team, position, skill level
    public Player updatePlayer(Player player){
        return playerDao.update(player);
    }

    public Player showByID(int playerId){
        return playerDao.findById(playerId);
    }

    public int deletePlayer(int playerID){
        return playerDao.delete(playerID);
    }

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
}
