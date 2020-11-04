package killerapp.backend.models;

import lombok.Data;
@Data
public class CoachCreateModel {
    private String userName;
    private String password;
    private String intro;
    private String lolname;
    private byte[] salt;

}

