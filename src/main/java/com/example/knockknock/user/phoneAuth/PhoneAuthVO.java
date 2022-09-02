package com.example.knockknock.user.phoneAuth;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phone_auth")
public class PhoneAuthVO {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "auth_code")
    private String authCode;

    @Column(name = "sending_time")
    private Timestamp sendingTime;

}