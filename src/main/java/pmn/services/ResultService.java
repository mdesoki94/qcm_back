package pmn.services;

import pmn.models.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {

    List<Result> findAll();
    Optional<Result> findById(Long id);
    Result save(Result result);
    List<Result> findAllByUserId(Long id);
}
