package com.example.nalsam.user.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class UserResponse {

    private String loginId;

    private String userName;

    private String birthDate;

    private Integer isMale;

    private String symptom;

    private Integer heartRate;

    private Integer oxygenSaturation;

}

