package pmn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmn.dtos.LoginRequestDto;
import pmn.models.AppUser;
import pmn.services.LoginService;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<AppUser> login(@RequestBody LoginRequestDto loginRequestDto) {
        Optional<AppUser> opt = loginService.login(loginRequestDto.getLastName().trim().toLowerCase(), loginRequestDto.getPassword().trim());
        if (opt.isPresent()) {
            if(opt.get().getIsActive()){
                return new ResponseEntity<>(opt.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
