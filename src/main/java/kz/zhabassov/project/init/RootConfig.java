package kz.zhabassov.project.init;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kz.zhabassov.project.dao.*;
import kz.zhabassov.project.service.GameService;
import kz.zhabassov.project.service.PlayerService;
import kz.zhabassov.project.service.TeamService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"kz.zhabassov.project"})
public class RootConfig {

    @Bean
    public DataSource dataSource() {

            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setUsername("postgres");
            config.setPassword("admin");
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/project");

            HikariDataSource ds = new HikariDataSource(config);

            return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public GameDao getGameDao() {
        GameDao gameDao = new GameDao();
        gameDao.setNamedParameterJdbcTemplate(getNamedJdbcTemplate());
        gameDao.setJdbcTemplate(getJdbcTemplate());
        return gameDao;
    }

    @Bean
    public PenaltyDao getPenaltyDao() {
        PenaltyDao penaltyDao = new PenaltyDao();
        penaltyDao.setNamedParameterJdbcTemplate(getNamedJdbcTemplate());
        penaltyDao.setJdbcTemplate(getJdbcTemplate());
        return penaltyDao;
    }

    @Bean
    public PenaltyOfPlayerInGameDao getPenaltyOfPlayerInGameDao() {
        PenaltyOfPlayerInGameDao penaltyOfPlayerInGameDao = new PenaltyOfPlayerInGameDao();
        penaltyOfPlayerInGameDao.setNamedParameterJdbcTemplate(getNamedJdbcTemplate());
        penaltyOfPlayerInGameDao.setJdbcTemplate(getJdbcTemplate());
        return penaltyOfPlayerInGameDao;
    }

    @Bean
    public PlayerDao getPlayerDao() {
        PlayerDao playerDao = new PlayerDao();
        playerDao.setNamedParameterJdbcTemplate(getNamedJdbcTemplate());
        playerDao.setJdbcTemplate(getJdbcTemplate());
        return playerDao;
    }

    @Bean
    public TeamDao getTeamDao() {
        TeamDao teamDao = new TeamDao();
        teamDao.setNamedParameterJdbcTemplate(getNamedJdbcTemplate());
        teamDao.setJdbcTemplate(getJdbcTemplate());
        return teamDao;
    }

    @Bean
    public GameService getGameService() {
        GameService gameService = new GameService();
        gameService.setGameDao(getGameDao());
        return gameService;
    }

    @Bean
    public PlayerService getPlayerService() {
        PlayerService playerService = new PlayerService();
        playerService.setPlayerDao(getPlayerDao());
        return playerService;
    }

    @Bean
    public TeamService getTeamService() {
        TeamService teamService = new TeamService();
        teamService.setPlayerDao(getPlayerDao());
        teamService.setTeamDao(getTeamDao());
        return teamService;
    }


}
