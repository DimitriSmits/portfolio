package killerapp.backend.models;

import lombok.Data;

@Data
public class CoachEditModel {
    private Long coachId;
    private String userName;
    private String intro;
    private String lolname;
    private String discord;

}
