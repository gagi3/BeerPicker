package rs.beerpicker.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.beerpicker.server.model.auth.JWTResponse;
import rs.beerpicker.server.model.auth.SignInRequest;
import rs.beerpicker.server.model.auth.SignUpRequest;
import rs.beerpicker.server.model.auth.User;
import rs.beerpicker.server.repository.RoleRepository;
import rs.beerpicker.server.service.abstraction.UserService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody SignUpRequest request) {
        User user = userService.create(request);
        if (user == null) {
            return new ResponseEntity<>("Unsuccessful registration!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successful registration!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInRequest request) {
        JWTResponse response = userService.login(request);
        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
