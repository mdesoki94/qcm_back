package pmn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmn.models.Result;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByAppUserId(Long id);
}
