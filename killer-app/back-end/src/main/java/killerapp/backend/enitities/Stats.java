package killerapp.backend.enitities;

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
    @GeneratedValue
    private Long statsId;
    private String queueType;
    private String tier;
    private String rank;
    private String summonerID;
    private int leaguePoints;
    private int wins;
    private int losses;
    private double winrate;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userId" /*, referencedColumnName = "statsId"*/)
    private User user;

    private String videoURL;

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
}
