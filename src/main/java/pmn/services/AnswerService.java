package pmn.services;

import pmn.models.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    Answer save(Answer answer);

}
