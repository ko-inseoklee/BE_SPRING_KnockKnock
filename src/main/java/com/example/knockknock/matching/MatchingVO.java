package com.example.knockknock.matching;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matching")
@Getter @Setter
public class MatchingVO {//RE
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

}