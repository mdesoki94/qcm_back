package pmn.services;

import pmn.models.UserAnswer;

import java.util.List;
import java.util.Optional;

public interface UserAnswerService {

    List<UserAnswer> findAll();
    Optional<UserAnswer> findById(Long id);
    UserAnswer save(UserAnswer userAnswer);

}
