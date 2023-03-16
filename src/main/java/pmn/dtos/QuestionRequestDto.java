package pmn.dtos;

import lombok.Data;
import pmn.models.Answer;

import java.util.List;

@Data
public class QuestionRequestDto {

    private Long id;
    private String content;
    private Boolean isActive;
    private Long quizId;
    private List<Answer> answers;

}
