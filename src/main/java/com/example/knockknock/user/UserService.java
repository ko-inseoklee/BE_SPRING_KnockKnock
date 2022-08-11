package com.example.knockknock.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    UserVO signUp (UserVO userVO) {
        _userRepository.save(userVO);
        return userVO;
    }

    UserVO signIn (String email) {
        Optional<UserVO> user = _userRepository.findByEmail(email);
        if (user.isPresent()){
            return user.get();
        } else return null;
    }

    UserVO resetPassword (String email, String newPassword) {
        _userRepository.updatePassword(newPassword, email);
        return _userRepository.findByEmail(email).get();
    }
}
