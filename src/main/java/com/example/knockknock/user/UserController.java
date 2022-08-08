package com.example.knockknock.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService _userService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailDuplication (@RequestParam String email) {
        return new ResponseEntity<Boolean>(_userService.checkEmailDuplication(email), HttpStatus.FOUND);
    }

    @GetMapping("/check-nickname")
    public ResponseEntity<Boolean> checkNicknameDuplication (@RequestParam String nickName) {
        return new ResponseEntity<Boolean>(_userService.checkNicknameDuplication(nickName), HttpStatus.FOUND);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp (@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(_userService.signUp(user),HttpStatus.CREATED);

    }

    @GetMapping("/sign-in")
    public ResponseEntity<Boolean> signIn (@RequestParam String email,@RequestParam String password) {
        password = passwordEncoder.encode(password);
        return new ResponseEntity<Boolean>(_userService.signIn(email, password),HttpStatus.OK);
    }

    @GetMapping("/reset-password")
    public ResponseEntity<User> resetPassword (User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<User>(_userService.resetPassword(user), HttpStatus.OK);
    }
}
