package kz.zhabassov.project.service;

import kz.zhabassov.project.dao.PlayerDao;
import kz.zhabassov.project.dao.TeamDao;
import kz.zhabassov.project.entity.Game;
import kz.zhabassov.project.entity.Player;
import kz.zhabassov.project.entity.Team;

import java.util.List;

public class TeamService {
    private TeamDao teamDao;
    private PlayerDao playerDao;
    //get all, name, games, goals, coach, captain
    public List<Team> showAll(){
        return teamDao.findAll();
    }

    //get first five, name, games, goals
    public List<Team> showFirstFive(){
        return teamDao.findFirstFiveWithMaxScore();
    }
    //update name, coach, captain
    public Team update(Team team){
        return teamDao.update(team);
    }
    //insert name, games, goals, coach, captain
    public Team insert(Team team){
        String captainName = team.getCaptainName();
//        :TODO
//        Player player = playerDao.findByName(captainName);
//        if (null==player){
//            player = new Player();
//            player.setName(captainName);
//            Player newPlayer = playerDao.insert(player);
//            team.setCaptain(newPlayer.getPlayerId());
//        }else {
//            team.setCaptain(player.getPlayerId());
//        }
        return teamDao.insert(team);
    }

    public Team findByTeam(String team){
        Team teamFound = teamDao.findByTeam(team);
        return teamFound;
    }

    public String deleteTeam(String team){
        String deletedTeam = teamDao.delete(team);
        return deletedTeam;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
}
