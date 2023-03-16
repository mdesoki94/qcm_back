package pmn.dtos;

import lombok.Data;

@Data
public class ResultDto {

    private Long quizId;
    private Long appUserId;
    private Integer score;
    private Integer timeUsed;
    private Integer nbrUnanswered;
    private Integer nbrRightAnswers;
    private Integer nbrWrongAnswers;
    private Integer nbrQuestions;

}
