package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.dtos.ResultDto;
import pmn.models.Result;
import pmn.services.AppUserService;
import pmn.services.QuizService;
import pmn.services.ResultService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<Result>> findAll() {
        return ResponseEntity.ok().body(resultService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> findById(@PathVariable Long id) {
        Optional<Result> opt = resultService.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Result>> findByAllByUserId(@PathVariable Long id) {
        List<Result> internResults = resultService.findAllByUserId(id);
        for (Result result:internResults) {
            result.setQuizName(quizService.findById(result.getQuiz().getId()).get().getName());
        }
        return ResponseEntity.ok().body(internResults);
    }

    @PostMapping
    public ResponseEntity<Result> create(@RequestBody ResultDto resultDto) {
        Result result = new Result(resultDto.getNbrRightAnswers(), resultDto.getNbrWrongAnswers(),
                resultDto.getNbrUnanswered(), resultDto.getTimeUsed(), LocalDate.now(ZoneId.of("Europe/Paris")));
        result.setScore((int) Math.round(100.0 / resultDto.getNbrQuestions() * resultDto.getNbrRightAnswers()));
        result.setQuiz(quizService.findById(resultDto.getQuizId()).get());
        result.setAppUser(appUserService.findById(resultDto.getAppUserId()).get());
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Result> update(@RequestBody Result result) {
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
    }

}
