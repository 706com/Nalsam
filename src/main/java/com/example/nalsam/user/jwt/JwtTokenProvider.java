package com.example.nalsam.user.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

/*
토큰을 생성하고 검증하는 컴포넌트를 완성했지만
실제로 이 컴포넌트를 이용하는 것은 인증 작업을 진행하는 Filter 입니다.
이 필터는 검증이 끝난 JWT로부터 유저정보를 받아와서
UsernamePasswordAuthenticationFilter 로 전달해야 할 것입니다.
 */

@Component
public class JwtTokenProvider {

    private final String secretKey;

    private final long expirationHours;

    private final String issuer;

    private final CustomUserDetailService customUserDetailService;

//    public JwtTokenProvider(String secretKey, long expirationHours, String issuer, CustomUserDetailService customUserDetailService) {
//        this.secretKey = secretKey;
//        this.expirationHours = expirationHours;
//        this.issuer = issuer;
//        this.customUserDetailService = customUserDetailService;
//    }

    public JwtTokenProvider(@Value("${jwt-secret-key}") String secretKey,
                            @Value("${jwt-expiration-hours}")long expirationHours,
                            @Value("${jwt-issuer}") String issuer,
                            CustomUserDetailService customUserDetailService) {
//        this.secretKey = secretKey;
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.expirationHours = expirationHours;
        this.issuer = issuer;
        this.customUserDetailService = customUserDetailService;
    }

    //jwt 생성
    public String createToken(String userPk){
        Claims claims = Jwts.claims().setSubject(userPk);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setClaims(claims)  //정보저장
                .setIssuer(issuer)  //토큰 발급자
                .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))    //발급시각
                .setExpiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))    //만료 시각
                .compact();
    }

    // JWT 에서 인증 정보 조회
    public Authentication getAuthentication(String token){
        UserDetails userDetails = customUserDetailService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //토큰에서 회원 추출
    public String getUserPk(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //Request의 Header에서 token 값 가져오기. "X-AUTH-TOKEN" : "TOKEN값'
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("X-AUTH-TOKEN");
    }

    // 토큰 유효성(access) 및 만료일자 확인
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new java.util.Date());
        } catch (Exception e){
            return false;
        }
    }
}
