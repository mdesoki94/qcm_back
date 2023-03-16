package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.dtos.QuestionRequestDto;
import pmn.models.Question;
import pmn.services.QuestionService;
import pmn.services.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        Optional<Question> opt = questionService.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody QuestionRequestDto questionRequestDto) {
        Question question = new Question(questionRequestDto.getContent(), questionRequestDto.getIsActive(), questionRequestDto.getAnswers());
        question.setQuiz(quizService.findById(questionRequestDto.getQuizId()).get());
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Question> update(@RequestBody QuestionRequestDto questionRequestDto) {
        Question question = new Question(questionRequestDto.getId(), questionRequestDto.getContent(), questionRequestDto.getIsActive(), questionRequestDto.getAnswers());
        question.setQuiz(quizService.findById(questionRequestDto.getQuizId()).get());
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }


    @GetMapping("/quiz/{id}")
    public ResponseEntity<List<Question>> findAllByQuizId(@PathVariable Long id) {
        return ResponseEntity.ok().body(questionService.findAllByQuizIdAndIsActiveTrue(id));
    }

    @GetMapping("/quizAdmin/{id}")
    public ResponseEntity<List<Question>> findAllByQuizIdAdmin(@PathVariable Long id) {
        return ResponseEntity.ok().body(questionService.findAllByQuizId(id));
    }


}
