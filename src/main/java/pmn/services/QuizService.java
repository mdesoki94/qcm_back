package pmn.services;

import pmn.models.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> findAll();
    Optional<Quiz> findById(Long id);
    Quiz save(Quiz quiz);
    List<Quiz> findAllForIntern();
}
