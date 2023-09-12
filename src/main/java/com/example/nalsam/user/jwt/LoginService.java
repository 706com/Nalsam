package com.example.nalsam.user.jwt;

import com.example.nalsam.user.domain.User;
import com.example.nalsam.user.dto.request.LoginRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import com.example.nalsam.user.exception.UserAlreadyExistException;
import com.example.nalsam.user.repository.UserRepository;
import com.example.nalsam.user.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class LoginService {

    private final BCryptPasswordEncoder encoder;

    private final UserRepository userRepository;

    private AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    public LoginService(BCryptPasswordEncoder encoder, UserRepository userRepository, AuthenticationManagerBuilder authenticationManagerBuilder, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /*
        1. login 요청이 들어오면, 유저정보의 인증과정 진행
        2. loginId 와 password 기반의 Authenticaion Token 객체를 생성 후 검증과정 진행
        3. 검증된 인증 정보로 JWT 토큰 생성
    */
    public JwtToken login(LoginRequest request){

        // 계정 로그인 정보 확인 (아이디 패스워드)
        userService.checkUserInfo(request);
        // Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getLoginId(),request.getPassword());
        //검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //검증된 인증정보로 jwt 생성
        JwtToken token = jwtTokenProvider.createToken(authentication,request.getLoginId());

        return token;

    }

    // 회원가입
    public void createUser(UserRequest userRequest){

        if(userRepository.existsByLoginId(userRequest.getLoginId())){
            throw new UserAlreadyExistException();
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        Integer testOxygen = 90;   //산소포화도 테스트 데이터
        Integer testHeartRate = 80; //심박수 테스트 데이터

        String encPwd = encoder.encode(userRequest.getPassword());

        User user = User.builder()
                .loginId(userRequest.getLoginId())
                .password(encPwd)
                .name(userRequest.getUserName())
                .birthDate(userRequest.getBirthDate())
                .isMale(userRequest.getIsMale())
                .heartRate(testHeartRate)
                .oxygenSaturation(testOxygen)
                .symptom(userRequest.getSymptom())
                .createDateTime(localDateTime)
                .updateDateTime(localDateTime)
                .build();

        userRepository.save(user);
    }

}
