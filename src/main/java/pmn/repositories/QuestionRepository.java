package pmn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmn.models.Question;
import pmn.models.Quiz;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByQuizId(Long id);
    List<Question> findAllByQuizIdAndIsActiveTrue(Long id);
    Integer countAllByQuizAndIsActiveTrue(Quiz quiz);
}
