package killerapp.backend.models;

import killerapp.backend.enitities.Stats;
import lombok.Data;
@Data
public class UserCreateModel {
        private String userName;
        private String password;
        private String lolname;
        private byte[] salt;
        private Stats stats;



}
