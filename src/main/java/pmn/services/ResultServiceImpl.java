package pmn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmn.models.Result;
import pmn.repositories.ResultRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public List<Result> findAllByUserId(Long id) {
        return resultRepository.findAllByAppUserId(id);
    }

}
