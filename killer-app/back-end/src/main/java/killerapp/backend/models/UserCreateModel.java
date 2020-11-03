package killerapp.backend.models;

import lombok.Data;
@Data
public class UserCreateModel {
        private String userName;
        private String password;
        private byte[] salt;

}
