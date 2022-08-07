package com.example.knockknock.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.email = ?1, u.name = ?2, u.phoneNumber = ?3, u.password = ?4, u.nickname = ?5, u.birth = ?6, u.sex = ?7, u.job = ?8 " +
            "where u.id = ?9")
    void updateUser(String email, String name, String phoneNumber, String password, String nickname, Integer birth, String sex, String job, Long id);

    long countByNickname(String nickname);

    long countByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);


}