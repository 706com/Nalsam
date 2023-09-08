package com.example.nalsam.user.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Column(name = "login_id")
    private String loginId;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "birth_date")
    private String birthDate;

    @NotNull
    @Column(name = "is_male")
    private Integer isMale;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;

    private String symptom;

    @Column(name = "create_date_time")
    private LocalDateTime createDateTime; // == create_data_time

    @Column(name ="update_date_time")
    private LocalDateTime updateDateTime;


    @Builder
    public User(Long userId, String loginId, String password, String userName, String birthDate, Integer isMale, Integer heartRate, Integer oxygenSaturation, String symptom, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.heartRate = heartRate;
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
