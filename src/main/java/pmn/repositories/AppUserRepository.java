package pmn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pmn.models.AppUser;
import pmn.models.Role;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByLastNameAndPasswordAndIsActiveTrue(String lastName, String password);

    List<AppUser> findAllByRole(Role role);

}
