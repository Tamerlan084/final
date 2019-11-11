package kz.zhabassov.project.entity;

import lombok.Data;

@Data
public class Player {
    private int playerId;
    private String name;
    private String position;
    private String skillLevel;
    private String team;

}


