package com.example.knockknock.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository _userRepository;

    boolean checkEmailDuplication (String email) {
        return _userRepository.countByEmail(email) > 0;
    }

    boolean checkNicknameDuplication (String nickName) {
        return _userRepository.countByNickname(nickName) > 0;
    }

    void signUp (User user) {
        _userRepository.save(user);
    }

    boolean signIn (String email, String password) {
        return _userRepository.existsByEmailAndPassword(email, password);
    }

    void resetPassword (User user) {
        _userRepository.updateUser(user.getEmail(),user.getName(),user.getPhoneNumber(),user.getPassword(),user.getNickname(),user.getBirth(),user.getSex(),user.getJob(), user.getId());
    }
}
