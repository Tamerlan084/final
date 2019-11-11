package kz.zhabassov.project.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Team implements Serializable {
    private String team;
    private String city;
    private String coach;
    private int captain;
    private String captainName;
}
