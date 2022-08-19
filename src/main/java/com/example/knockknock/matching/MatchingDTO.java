package com.example.knockknock.matching;

import com.example.knockknock.matching.age.AgeVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MatchingDTO {
    private String title;
    private String topic;
    private int creatorId;
    private int participantId;
    private List<Integer> ageRequirements;
    //RE
}
