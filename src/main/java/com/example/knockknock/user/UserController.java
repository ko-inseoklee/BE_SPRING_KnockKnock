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
    public ResponseEntity<Boolean> checkNicknameDuplication (@RequestParam String nickname) {
        return new ResponseEntity<Boolean>(_userService.checkNicknameDuplication(nickname), HttpStatus.FOUND);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserVO> signUp (@RequestBody UserVO userVO) {
        userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
        return new ResponseEntity<UserVO>(_userService.signUp(userVO),HttpStatus.CREATED);

    }

    @GetMapping("/sign-in")
    public ResponseEntity<Boolean> signIn (@RequestParam String email,@RequestParam String password) {
        UserVO currentUserVO = _userService.signIn(email);
        if (currentUserVO == null) return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        else {
            boolean result = passwordEncoder.matches(password, currentUserVO.getPassword());
            if (result) return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            else return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<UserVO> resetPassword (@RequestParam String email, @RequestParam String newPassword) {
        newPassword = passwordEncoder.encode(newPassword);
        System.out.println(newPassword);
        return new ResponseEntity<UserVO>(_userService.resetPassword(email, newPassword),HttpStatus.OK);
    }
}
