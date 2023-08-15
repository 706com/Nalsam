package com.example.nalsam.user.dto.request;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {

    @Column(name = "login_id")
    private String loginId;

    private String password;

    @Column(name = "user_name")
    private String userName;

    private LocalDate birthDate;

    @Column(name = "is_male")
    private Integer isMale;

    private String location;

    private String symptom;


    @Builder
    public UserRequest(String loginId, String password, String userName,LocalDate birthDate, Integer isMale, String location, String symptom) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.location = location;
        this.symptom = symptom;
    }
}
