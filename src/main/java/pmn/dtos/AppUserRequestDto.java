package pmn.dtos;

import lombok.Data;
import pmn.models.Role;

@Data
public class AppUserRequestDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String company;
    private String password;
    private Role role = Role.INTERN;
    private Boolean isActive;

}
