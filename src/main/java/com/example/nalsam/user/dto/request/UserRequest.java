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

    private String birthDate;

    @Column(name = "is_male")
    private Integer isMale;

    private String symptom;


    @Builder
    public UserRequest(String loginId, String password, String userName,String birthDate, Integer isMale, String symptom) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.symptom = symptom;
    }
}
