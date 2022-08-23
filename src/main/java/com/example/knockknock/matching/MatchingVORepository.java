package com.example.knockknock.matching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MatchingVORepository extends JpaRepository<MatchingVO, Integer> {
    @Override
    Optional<MatchingVO> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Transactional
    @Modifying
    @Query("update MatchingVO m set m.participantId = ?1 where m.id = ?2")
    int updateParticipantIdById(int participantId, Integer id);

    Optional<MatchingVO> findByTitleAndCreatorId(String title, int creatorId);
}