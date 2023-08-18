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
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "login_id")
    private String loginId;

    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_male")
    private Integer isMale;

    private String location;

    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;

    private String symptom;

    @Column(name = "create_date_time")
    private LocalDateTime createDateTime; // == create_data_time

    @Column(name ="update_date_time")
    private LocalDateTime updateDateTime;


    @Builder
    public User(Long userId, String loginId, String password, String userName, String birthDate, Integer isMale, String location, Integer oxygenSaturation, String symptom, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.userId = userId;
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

    public void updatePassword(String password, LocalDateTime updateDateTime) {
        this.password = password;
        this.updateDateTime = updateDateTime;
    }
}
