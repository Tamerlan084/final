package kz.zhabassov.project.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Game implements Serializable {
    private int gameId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int hostScore;
    private int guestScore;
    private String hostTeam;
    private String guestTeam;

}
