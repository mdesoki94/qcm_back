package pmn.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Boolean isCorrect;
    @Column(nullable = false)
    private Boolean hasAnswered;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Question question;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private AppUser appUser;

    public UserAnswer(Boolean isCorrect, Boolean hasAnswered) {
        this.isCorrect = isCorrect;
        this.hasAnswered = hasAnswered;
    }
}
