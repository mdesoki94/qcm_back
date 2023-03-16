package pmn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmn.models.AppUser;
import pmn.models.Role;
import pmn.repositories.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public List<AppUser> findAllByRole(Role role) {
        return appUserRepository.findAllByRole(role);
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
