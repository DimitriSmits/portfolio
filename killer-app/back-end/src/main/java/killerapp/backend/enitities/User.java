package killerapp.backend.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String password;
    private String lolname;
    @Lob
    private byte[] salt;
    @OneToOne(mappedBy = "Stats")
    private Stats stats;

    public User() {
    }

    public User(String userName, String password,String lolname,byte[] salt) {
        this.userName = userName;
        this.password = password;
        this.lolname = lolname;
        this.salt = salt;
    }
    public User(String userName, String password,String lolname,byte[] salt,Stats stats) {
        this.userName = userName;
        this.password = password;
        this.lolname = lolname;
        this.salt = salt;
        this.stats = stats;
    }
}
