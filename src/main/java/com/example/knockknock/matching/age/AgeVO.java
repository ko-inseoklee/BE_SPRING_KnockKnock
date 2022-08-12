package com.example.knockknock.matching.age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "matching_age")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgeVO {
    @Id
    @Column(name = "age_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "matching_id")
    private int matchingId;

    @Column(name = "requirement_age")
    private int age;



}
