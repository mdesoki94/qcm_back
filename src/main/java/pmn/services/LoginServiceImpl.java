package pmn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pmn.models.AppUser;
import pmn.repositories.AppUserRepository;
import pmn.security.Encrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AppUserRepository appUserRepository;

    private Encrypt encrypt = new Encrypt();

    @Override
    public Optional<AppUser> login(String name, String password) {
        return appUserRepository.findByLastNameAndPasswordAndIsActiveTrue(name, encrypt.cryptString(password));
    }
}
