package com.example.nalsam.user.jwt;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
public class LoginResponse {

    private String loginId;

    private String userName;

    private String birthDate;

    private Integer isMale;

    private Integer heartRate;

    private Integer oxygenSaturation;

    private String symptom;

    private String accessToken;

    private String refreshToken;


    @Builder
    public LoginResponse(String loginId, String userName, String birthDate, Integer isMale, Integer heartRate, Integer oxygenSaturation, String symptom, String accessToken, String refreshToken) {
        this.loginId = loginId;
        this.userName = userName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.heartRate = heartRate;
        this.oxygenSaturation = oxygenSaturation;
        this.symptom = symptom;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
