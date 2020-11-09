package killerapp.backend.enitities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static java.lang.Math.round;


@Entity
@Getter
@Setter
public class Stats {
    @Id
    @Column(name="user_id")
    private Long statsId;
    private String queueType;
    private String tier;
    private String rank;
    private String summonerID;
    private int leaguePoints;
    private int wins;
    private int losses;
    private double winrate;
    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    public Stats() {
    }
    public Stats(String queueType,String tier,String rank,String summonerID,int leaguePoints,int wins,int losses) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.summonerID = summonerID;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        //Calculate winrate
        double winrateCalc = wins/ ((double)wins+losses)*100;
        this.winrate = (int)winrateCalc;
    }

    public Stats(String queueType,String tier,String rank,String summonerID,int leaguePoints,int wins,int losses,User user) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.summonerID = summonerID;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        //Calculate winrate
        double winrateCalc = wins/ ((double)wins+losses)*100;
        this.winrate = (int)winrateCalc;
        this.user = user;
    }
}
