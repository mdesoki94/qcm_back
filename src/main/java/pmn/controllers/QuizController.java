package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.models.Question;
import pmn.models.Quiz;
import pmn.services.QuestionService;
import pmn.services.QuizService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Quiz>> findAll() {
        return ResponseEntity.ok().body(quizService.findAll());
    }

    @GetMapping("/intern")
    public ResponseEntity<List<Quiz>> findAllForIntern() {
        List<Quiz> validQuizzes = quizService.findAllForIntern().stream().map(quiz -> {
            quiz.setNbOfQuestions(questionService.countAllByQuizAndIsActiveTrue(quiz));
            return quiz;
        }).filter(quiz -> quiz.getNbOfQuestions() > 2).collect(Collectors.toList());
        return ResponseEntity.ok().body(validQuizzes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findById(@PathVariable Long id) {
        Optional<Quiz> opt = quizService.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.save(quiz), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
        if ((quiz.getIsActive() == true && quizService.findById(quiz.getId()).get().getIsActive() == false) ||
                (quiz.getIsActive() == false && quizService.findById(quiz.getId()).get().getIsActive() == true)) {
            List<Question> quizQuestions = questionService.findAllByQuizId(quiz.getId());
            quizQuestions.forEach(question -> question.setIsActive(quiz.getIsActive()));
            questionService.saveAll(quizQuestions);
        }
        return new ResponseEntity<>(quizService.save(quiz), HttpStatus.CREATED);
    }

}
