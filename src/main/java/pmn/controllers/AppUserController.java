package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.dtos.AppUserRequestDto;
import pmn.models.AppUser;
import pmn.models.Role;
import pmn.security.Encrypt;
import pmn.services.AppUserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    private Encrypt encrypt = new Encrypt();

    @GetMapping
    public ResponseEntity<List<AppUser>> findAllInterns() {
        return ResponseEntity.ok().body(appUserService.findAllByRole(Role.INTERN));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> findById(@PathVariable Long id) {
        Optional<AppUser> opt = appUserService.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<AppUser> create(@RequestBody AppUserRequestDto appUserRequestDto) {
        AppUser appUser = new AppUser(appUserRequestDto.getLastName().trim().toLowerCase(), appUserRequestDto.getFirstName().trim(),
                appUserRequestDto.getCompany().trim(), encrypt.cryptString(appUserRequestDto.getPassword().trim()), appUserRequestDto.getIsActive());
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AppUser> update(@RequestBody AppUserRequestDto appUserRequestDto) {
        AppUser appUser = new AppUser(appUserRequestDto.getId(), appUserRequestDto.getLastName().trim().toLowerCase(), appUserRequestDto.getFirstName().trim(),
                appUserRequestDto.getCompany().trim(), appUserRequestDto.getIsActive());
        if (appUserRequestDto.getPassword() == null) {
            appUser.setPassword(appUserService.findById(appUser.getId()).get().getPassword());
        } else {
            appUser.setPassword(encrypt.cryptString(appUserRequestDto.getPassword()).trim());
        }
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.CREATED);
    }

}
