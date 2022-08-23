package com.example.knockknock.matching;

import com.example.knockknock.matching.age.AgeRepository;
import com.example.knockknock.matching.age.AgeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MatchingService {
    private final MatchingVORepository matchingRepository;

    private final AgeRepository ageVORepository;

    @Autowired
    public MatchingService(MatchingVORepository matchingRepository, AgeRepository ageVORepository) {
        this.matchingRepository = matchingRepository;
        this.ageVORepository = ageVORepository;
    }
    //매칭방 생성
    @Transactional
    public MatchingDTO createMatchingRoom(MatchingDTO dto){
        if(matchingRepository.findByTitleAndCreatorId(dto.getTitle(), dto.getCreatorId()).isPresent())
            return null;

        MatchingVO vo = MatchingVO.builder()
                .title(dto.getTitle())
                .topic(dto.getTopic())
                .creatorId(dto.getCreatorId())
                .createdTime(new Date())
                .build();
        try{
            MatchingVO result = matchingRepository.save(vo);
            int[] ages = dto.getAgeRequirements();
            for(int i = 0; i < ages.length; i++)
                ageVORepository.save(new AgeVO(result.getId(), ages[i]));

            MatchingDTO response = new MatchingDTO();
            response.setId(result.getId());
            response.setTitle(result.getTitle());
            response.setTopic(result.getTopic());
            response.setCreatorId(result.getCreatorId());
            response.setAgeRequirements(ages);
            return response;
        } catch (RuntimeException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    //매칭방 수정
    void updateMatchingRoomInfo(){

    }

    //매칭방 삭제
    @Transactional
    public boolean deleteMatchingRoom(int id){
        try{
            ageVORepository.deleteByMatchingId(id);
            matchingRepository.deleteById(Integer.valueOf(id));

            return true;
        }catch (Exception e){
            log.info(e.getMessage());

            return false;
        }
    }

    //매칭방 입장
    public MatchingDTO enterMatchingRoom(int matchingId, int participantId){
        try{
            matchingRepository.updateParticipantIdById(participantId,matchingId);
            MatchingVO vo = matchingRepository.findById(Integer.valueOf(matchingId)).get();
            List<AgeVO> ages = ageVORepository.findByMatchingId(matchingId);

            MatchingDTO result = new MatchingDTO();
            result.setId(vo.getId());
            result.setTitle(vo.getTitle());
            result.setTopic(vo.getTopic());
            result.setCreatorId(vo.getCreatorId());
            result.setParticipantId(vo.getParticipantId());
            int[] resultAges = new int[ages.size()];
            for(int i = 0; i < ages.size(); i++){
                resultAges[i] = ages.get(i).getAge();
            }
            result.setAgeRequirements(resultAges);

            return result;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }
    }

    //매칭방 퇴장
    public boolean exitMatchingRoom(int matchingId){
        try{
            matchingRepository.updateParticipantIdById(0,matchingId);

            return true;
        } catch (Exception e){
            log.info(e.getMessage());

            return false;
        }
    }

    //re
}
