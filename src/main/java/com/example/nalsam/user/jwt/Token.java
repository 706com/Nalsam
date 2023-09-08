package com.example.nalsam.user.jwt;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String loginId;

    private String role;

    private String type;

    private String token;

    @Builder
    public Token(String loginId,String role, String type, String token) {
        this.loginId = loginId;
        this.role = role;
        this.type = type;
        this.token = token;
    }
}
