package pmn.services;

import pmn.models.AppUser;
import pmn.models.Role;

import java.util.List;
import java.util.Optional;

public interface AppUserService {

    List<AppUser> findAll();

    List<AppUser> findAllByRole(Role role);
    Optional<AppUser> findById(Long id);
    AppUser save(AppUser appUser);
}
