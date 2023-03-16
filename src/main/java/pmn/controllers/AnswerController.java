package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.models.Answer;
import pmn.services.AnswerService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        return ResponseEntity.ok().body(answerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        Optional<Answer> opt = answerService.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Answer> create(@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Answer> update(@RequestBody Answer answer) {
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.CREATED);
    }

}
