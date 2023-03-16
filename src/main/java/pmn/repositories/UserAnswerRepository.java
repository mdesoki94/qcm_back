package pmn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmn.models.UserAnswer;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

}
