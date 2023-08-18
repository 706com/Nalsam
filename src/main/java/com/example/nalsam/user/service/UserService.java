package com.example.nalsam.user.service;

import com.example.nalsam.user.dto.request.TestRequest;
import com.example.nalsam.user.dto.request.UserPasswordRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import com.example.nalsam.user.dto.response.UserResponse;
import com.example.nalsam.user.repository.TestUserRepository;
import com.example.nalsam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nalsam.user.domain.Test;
import com.example.nalsam.user.domain.User;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final TestUserRepository testUserRepository;

    // 회원 저장 기능
    public void saveUserProfile(UserRequest userRequest){

        LocalDateTime localDateTime = LocalDateTime.now();

        Integer testOxygen = 100;   //산소포화도 테스트 데이터

        User user = User.builder()
                .loginId(userRequest.getLoginId())
                .password(userRequest.getPassword())
                .userName(userRequest.getUserName())
                .birthDate(userRequest.getBirthDate())
                .isMale(userRequest.getIsMale())
                .location(userRequest.getLocation())
                .oxygenSaturation(testOxygen)
                .symptom(userRequest.getSymptom())
                .createDateTime(localDateTime)
                .updateDateTime(localDateTime)
                .build();

        userRepository.save(user);
    }

    //회원 저장 기능 test
    public Test saveTest(TestRequest testRequest){

        Test test = Test.builder()
                .title(testRequest.getTitle())
                .content(testRequest.getContent())
                .build();

        testUserRepository.save(test);

        return test;
    }

    // 회원 조회 기능
    // 로그인ID 로 조회하기.
    public UserResponse showUserInfoById(String loginId){

        User user = userRepository.findByLoginId(loginId).orElseThrow();

        return UserResponse.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .birthDate(user.getBirthDate())
                .isMale(user.getIsMale())
                .location(user.getLocation())
                .symptom(user.getSymptom())
                .build();
    }

    // 회원 조회 기능
    // 모든 회원 보기
    public List<UserResponse> showUserInfoAll(){
        List<User> getUsers = userRepository.findAll();

        List<UserResponse> getUserInfo = getUsers.stream()
                .map(user -> UserResponse.builder()
                        .loginId(user.getLoginId())
                        .userName(user.getUserName())
                        .birthDate(user.getBirthDate())
                        .isMale(user.getIsMale())
                        .location(user.getLocation())
                        .symptom(user.getSymptom())
                        .build())
                .collect(Collectors.toList());

        return getUserInfo;
    }

    // 회원 정보 업데이트 - password
    @Transactional
    public void updateUserPassword(UserPasswordRequest request){
        if(!userRepository.existsByLoginId(request.getLoginId())){
            throw new IllegalArgumentException("해당 회원 ID 없음");
        }

        else if(!request.getPassword().equals(userRepository.findByLoginId(request.getLoginId()).get().getPassword())){
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        if(request.getNewPassword().equals(request.getNewPassword())){
            User user = userRepository.findByLoginId(request.getLoginId()).get();
            LocalDateTime now = LocalDateTime.now();
            user.updatePassword(request.getNewPassword(), now);
        }
    }

}
