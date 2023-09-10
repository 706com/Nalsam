package com.example.nalsam.user.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "user_info")
public class User implements UserDetails {

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
    private String name;

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
    public User(Long userId, String loginId, String password, String name, String birthDate, Integer isMale, Integer heartRate, Integer oxygenSaturation, String symptom, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
