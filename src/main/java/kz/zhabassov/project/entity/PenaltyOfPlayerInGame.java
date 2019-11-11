package kz.zhabassov.project.entity;

import lombok.Data;

@Data
public class PenaltyOfPlayerInGame {
    private int penaltyOfPlayerInGameId;
    private int playerId;
    private String playerName;
    private String penalty;
    private int game_id;

}
