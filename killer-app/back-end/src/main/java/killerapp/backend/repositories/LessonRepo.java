package killerapp.backend.repositories;

import killerapp.backend.enitities.Coach;
import killerapp.backend.enitities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {

}
