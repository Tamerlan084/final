package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.GameDao;
import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.entity.Team;

import java.util.List;

public class GameService {

    private GameDao gameDao;
    //get first 5 with host team and score, guest team and score
    public List<Game>  showLastFiveGames(){
        return gameDao.findLastFive();
    }

    //get all
    public List<Game> showAllGames(){
        return gameDao.findAll();
    }

    //update games with score
    public Game updateScore(Game game){
        return gameDao.update(game);
    }

    //add game
    public Game addGame(Game game){
        return  gameDao.insert(game);
    }

    public Game showByID(int gameId) {
        return gameDao.findById(gameId);
    }

    public void setGameDao(GameDao gameDao) {
        this.gameDao = gameDao;
    }


    public int deleteGame(int gameId) {
        return gameDao.delete(gameId);
    }
}
