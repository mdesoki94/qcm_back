package pmn.services;

import pmn.models.AppUser;

import java.util.Optional;

public interface LoginService {

    Optional<AppUser> login(String name, String password);

}
