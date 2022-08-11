package com.example.knockknock.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVO, Long> {
    @Transactional
    @Modifying
    @Query("update UserVO u set u.email = ?1, u.name = ?2, u.phoneNumber = ?3, u.password = ?4, u.nickname = ?5, u.birth = ?6, u.sex = ?7, u.job = ?8 " +
            "where u.id = ?9")
    void updateUser(String email, String name, String phoneNumber, String password, String nickname, Integer birth, String sex, String job, Long id);

    long countByNickname(String nickname);

    long countByEmail(String email);

    Optional<UserVO> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update UserVO u set u.password = ?1 where u.email = ?2")
    void updatePassword(String password, String email);

    @Transactional
    @Modifying
    @Query("update UserVO u set u.password = ?1 where u.email = ?2")
    int updatePasswordTest(String password, String email);




}