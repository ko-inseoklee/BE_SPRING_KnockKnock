package com.example.knockknock.matching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matching")
@Slf4j
public class MatchingController {

    private final MatchingService matchingService;

    @Autowired
    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    //매칭방 생성
    @PostMapping("/create")
    public ResponseEntity<MatchingDTO> createMatchingRoom(@RequestBody MatchingDTO dto){
        try{
            MatchingDTO result = matchingService.createMatchingRoom(dto);
            return new ResponseEntity<MatchingDTO>(result, HttpStatus.CREATED);
        } catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<MatchingDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    //매칭방 수정 TODO: 아직 디자인이 안 나옴.
    void updateMatchingRoomInfo(){

    }

    //매칭방 목록 불러오기
    @GetMapping("/list")
    public ResponseEntity<List<MatchingDTO>> getMatchingRoomList() {
        List<MatchingDTO> allList = matchingService.loadAllMatchings();

        return new ResponseEntity<List<MatchingDTO>>(allList,HttpStatus.OK);
    }

    //매칭방 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteMatchingRoom(@RequestParam int id){
        boolean response = matchingService.deleteMatchingRoom(id);
        HttpStatus statusCode;
        if (response)
            statusCode = HttpStatus.ACCEPTED;
        else
            statusCode = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(response,statusCode);
    }

    //매칭방 입장
    @PostMapping("/join")
    public ResponseEntity<MatchingDTO> enterMatchingRoom(@RequestParam int participantId,@RequestParam int matchingId){
        MatchingDTO result = matchingService.enterMatchingRoom(matchingId, participantId);
        if (result == null) return new ResponseEntity<MatchingDTO>(HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<MatchingDTO>(result, HttpStatus.OK);
    }

    //매칭방 퇴장
    @PostMapping("/exit")
    public ResponseEntity<Boolean> exitMatchingRoom(@RequestParam int participantId, @RequestParam int matchingId){
        boolean response = matchingService.exitMatchingRoom(matchingId);
        HttpStatus statusCode;
        if (response)
            statusCode = HttpStatus.ACCEPTED;
        else
            statusCode = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(response,statusCode);

    }

    //TODO: 매칭방 추방

    //매칭방 검색 TODO: 아직 디자인이 안 나옴.
    void searchMatchingRoom(){

    }
}
