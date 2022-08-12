package com.example.knockknock.matching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MatchingRepository extends JpaRepository<MatchingVO, Integer> {
    @Transactional
    @Modifying
    @Query("update MatchingVO m set m.title = ?1, m.topic = ?2 where m.id = ?3")
    void updateMatchingRoomInfo(String title, String topic, Integer id);

    @Override
    void deleteById(Integer integer);
}