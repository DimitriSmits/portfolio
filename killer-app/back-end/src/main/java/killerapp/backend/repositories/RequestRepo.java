package killerapp.backend.repositories;

import killerapp.backend.enitities.Coach;
import killerapp.backend.enitities.Request;
import killerapp.backend.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {
    Iterable<Request> findAllByUserAndAccepted(User user,Boolean accepted);
    Iterable<Request> findAllByCoachAndAccepted(Coach coach,Boolean accepted);
}
