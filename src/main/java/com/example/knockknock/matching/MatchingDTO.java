package com.example.knockknock.matching;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchingDTO {
    private int id;
    private String title;
    private String topic;
    private int creatorId;
    private int participantId;
    private int[] ageRequirements;
    //RE
}
