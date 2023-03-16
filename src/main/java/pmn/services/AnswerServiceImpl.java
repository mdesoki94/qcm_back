package pmn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmn.models.Answer;
import pmn.repositories.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl  implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }
}
