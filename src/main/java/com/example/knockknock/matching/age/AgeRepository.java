package com.example.knockknock.matching.age;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AgeRepository extends JpaRepository<AgeVO, Integer> {

    List<AgeVO> findByMatchingId(int matchingId);

    @Transactional
    @Modifying
    @Query("delete from AgeVO a where a.matchingId = ?1")
    void deleteByMatchingId(int matchingId);

    @Transactional
    @Modifying
    @Query("update AgeVO a set a.age = ?1 where a.id = ?2")
    int updateAge(int age, int id);

}