package killerapp.backend.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue
    private Long lessonId;
    private String title;
    private String description;
    private String videoURL;

    public Lesson() {
    }

    public Lesson(String title, String description,String videoURL) {
        this.title = title;
        this.description = description;
        this.videoURL = videoURL;
    }
}
