package com.example.nalsam.user.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "login_id")
    private String loginId;

    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_male")
    private Integer isMale;

    private String location;

    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;

    private String symptom;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;


    @Builder
    public User(Long userID, String loginId, String password, String userName, LocalDate birthDate, Integer isMale, String location, Integer oxygenSaturation, String symptom, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.userID = userID;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.location = location;
        this.oxygenSaturation = oxygenSaturation;
        this.symptom = symptom;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
