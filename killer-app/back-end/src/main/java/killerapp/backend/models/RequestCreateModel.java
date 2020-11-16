package killerapp.backend.models;

import lombok.Data;

@Data
public class RequestCreateModel {
    private Long userId;
    private Long coachId;
    private String question;
    private Boolean accepted;
}
