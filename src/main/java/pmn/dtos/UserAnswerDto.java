package pmn.dtos;

import lombok.Data;

@Data
public class UserAnswerDto {

    private Boolean isCorrect;
    private Boolean hasAnswered;
    private Long questionId;
    private Long appUserId;

}
