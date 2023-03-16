package pmn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmn.models.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
