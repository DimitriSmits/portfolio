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
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long userId;
    private String userName;
    private String password;
    private String lolname;
    @Lob
    private String salt;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stats stats;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<Request> requests;

    public User() {
    }

    public User(String userName, String password,String lolname,String salt) {
        this.userName = userName;
        this.password = password;
        this.lolname = lolname;
        this.salt = salt;
    }
    public User(String userName, String password,String lolname,String salt,Stats stats) {
        this.userName = userName;
        this.password = password;
        this.lolname = lolname;
        this.salt = salt;
        this.stats = stats;
    }
}
