package killerapp.backend.enitities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Coach{
    @Id
    @GeneratedValue
    private Long coachId;
    private String userName;
    private String password;
    private String intro;
    private String lolname;
    @Lob
    private byte[] salt;

    @JsonIgnore
    @OneToMany(mappedBy = "coach")
    Set<Request> requests;

    public Coach() {
    }

    public Coach(String userName, String password,String intro,String lolname,byte[] salt) {
        this.userName = userName;
        this.password = password;
        this.intro = intro;
        this.lolname = lolname;
        this.salt = salt;
    }
}