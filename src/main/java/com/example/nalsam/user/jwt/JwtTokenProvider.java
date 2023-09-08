package com.example.nalsam.user.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

@Service
public class JwtTokenProvider {

    private final String secretKey;

    private final Long expirationHours;

    private final String issuer;

    public JwtTokenProvider(@Value("${jwt-secret-key}") String secretKey,
                            @Value("${jwt-expiration-hours}")Long expirationHours,
                            @Value("${jwt-issuer}") String issuer) {
//        this.secretKey = secretKey;
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.expirationHours = expirationHours;
        this.issuer = issuer;
    }

    public String createToken(){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setSubject("udega")
                .setIssuer(issuer)
                .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
                .setExpiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))
                .compact();
    }
}
