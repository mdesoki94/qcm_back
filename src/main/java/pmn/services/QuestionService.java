package pmn.services;

import pmn.models.Question;
import pmn.models.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> findAllByQuizId(Long id);
    Optional<Question> findById(Long id);
    Question save(Question question);
    List<Question> findAllByQuizIdAndIsActiveTrue(Long id);

    Integer countAllByQuizAndIsActiveTrue(Quiz quiz);

    void saveAll(List<Question> quizQuestions);
}
