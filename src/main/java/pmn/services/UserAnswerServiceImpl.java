package pmn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmn.models.UserAnswer;
import pmn.repositories.UserAnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Override
    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }

    @Override
    public Optional<UserAnswer> findById(Long id) {
        return userAnswerRepository.findById(id);
    }

    @Override
    public UserAnswer save(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }
}
