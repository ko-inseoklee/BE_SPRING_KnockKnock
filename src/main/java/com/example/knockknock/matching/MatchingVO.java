package com.example.knockknock.matching;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "matching")
@Getter @Setter
@NoArgsConstructor
public class MatchingVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "creator", nullable = false)
    private int creatorId;

    @Column(name = "participant", nullable = false)
    private int participantId;

    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    public MatchingVO(String title, String topic, int creatorId, LocalDateTime createdTime) {

    }
//re
}