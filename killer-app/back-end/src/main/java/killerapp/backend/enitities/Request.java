package killerapp.backend.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name ="coach_id")
    private Coach coach;

    private String question;
    private Boolean accepted;
    private Boolean active;
    private String feedback;


    public Request() {

    }
    public Request(User user,Coach coach,String question,Boolean accepted,Boolean active,String feedback) {
        this.user = user;
        this.coach = coach;
        this.question = question;
        this.accepted = accepted;
        this.active = active;
        this.feedback = feedback;
    }


}
