package pmn.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private Boolean isActive;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnore
	private Quiz quiz;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "question_id")
	@Column(nullable = false)
	private List<Answer> answers;

	public Question(String content, Boolean active, List<Answer> answers) {
		this.content = content;
		this.isActive = active;
		this.answers = answers;
	}

	public Question(Long id, String content, Boolean isActive, List<Answer> answers) {
		this.id = id;
		this.content = content;
		this.isActive = isActive;
		this.answers = answers;
	}
}
