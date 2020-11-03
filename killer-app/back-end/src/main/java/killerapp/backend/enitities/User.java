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
    @Lob
    private byte[] salt;

    public User() {
    }

    public User(String userName, String password,byte[] salt) {
        this.userName = userName;
        this.password = password;
        this.salt = salt;
    }
}
