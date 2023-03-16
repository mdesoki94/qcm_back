package pmn.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "lastName", "password" }) })
public class AppUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String company;
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role = Role.INTERN;
	@Column(nullable = false)
	private Boolean isActive;

	public AppUser(String lastName, String firstName, String company, String password, Boolean isActive) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.company = company;
		this.password = password;
		this.isActive = isActive;
	}

	public AppUser(Long id, String lastName, String firstName, String company, Boolean isActive) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.company = company;
		this.isActive = isActive;
	}

}
