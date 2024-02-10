package com.example.nalsam.user.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String loginId;

    private String password;

    private String userName;

    private String birthDate;

    private Integer isMale;

    private String symptom;

}
