package com.example.knockknock.matching;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Entity
@Table(name = "matching")
@Getter @Setter
@AllArgsConstructor
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

    @Column(name = "participant")
    @ColumnDefault("0")
    private int participantId;

    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    public MatchingVO() {

    }

    //re
}