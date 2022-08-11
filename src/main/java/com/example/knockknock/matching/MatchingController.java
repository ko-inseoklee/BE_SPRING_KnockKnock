package com.example.knockknock.matching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    public String createMatchingRoom(@RequestBody MatchingDTO dto){
        try{
            matchingService.createMatchingRoom(dto);
            return "/success";
        } catch (Exception e){
            log.info(e.getMessage());

            return "/Fail";
        }
    }

    //매칭방 수정
    void updateMatchingRoomInfo(){

    }

    //매칭방 목록 불러오기
    void getMatchingRoomList() {

    }

    //매칭방 삭제
    void deleteMatchingRoom(){

    }

    //매칭방 입장
    void enterMatchingRoom(){

    }

    //매칭방 퇴장
    void exitMatchingRoom(){

    }

    @GetMapping("/success")
    public String onSuccess(){
        return "success";
    }

    @GetMapping("/fail")
    public String onFail(){
        return "fail";
    }
}
