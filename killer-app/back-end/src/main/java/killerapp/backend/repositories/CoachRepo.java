package killerapp.backend.repositories;

import killerapp.backend.enitities.Coach;
import killerapp.backend.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Long> {
    Coach findByUserName(String userName);
}
