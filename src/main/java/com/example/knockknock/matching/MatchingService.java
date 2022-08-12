package com.example.knockknock.matching;

import com.example.knockknock.matching.age.AgeRepository;
import com.example.knockknock.matching.age.AgeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MatchingService {
    private final MatchingRepository matchingRepository;

    private final AgeRepository ageVORepository;

    @Autowired
    public MatchingService(MatchingRepository matchingRepository, AgeRepository ageVORepository) {
        this.matchingRepository = matchingRepository;
        this.ageVORepository = ageVORepository;
    }
    //RE
    //매칭방 생성
    boolean createMatchingRoom(MatchingDTO dto){
        MatchingVO matching = new MatchingVO(dto.getId(),dto.getTitle(),dto.getTopic(),dto.getCreatorId(),dto.getParticipantId(),dto.getCreatedTime());
        List<AgeVO> ages = dto.getAgeRequirements();
        try{
            matchingRepository.save(matching);
            ageVORepository.saveAll(ages);
            return true;
        } catch (RuntimeException e) {
            log.info(e.getMessage());
            return false;
        }
    }

    //매칭방 수정
    void updateMatchingRoomInfo(MatchingDTO dto){
        List<AgeVO> ages = dto.getAgeRequirements();
        try{
            matchingRepository.updateMatchingRoomInfo(dto.getTitle(), dto.getTopic(), dto.getId());
            for(int i = 0; i < ages.size(); i++){
                ageVORepository.updateAge(ages.get(i).getAge(),ages.get(i).getId());
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    //매칭방 삭제
    boolean deleteMatchingRoom(Integer id){
        try{
            matchingRepository.deleteById(id);
            return true;
        } catch (Exception e){
            log.info(e.getMessage());
            return false;
        }
    }

    //매칭방 입장
    void enterMatchingRoom(){

    }

    //매칭방 퇴장
    void exitMatchingRoom(){

    }
}
