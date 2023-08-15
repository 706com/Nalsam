package com.example.nalsam.user.service;

import com.example.nalsam.user.dto.request.TestRequest;
import com.example.nalsam.user.dto.request.UserRequest;
import com.example.nalsam.user.repository.TestUserRepository;
import com.example.nalsam.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nalsam.user.domain.Test;
import com.example.nalsam.user.domain.User;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final TestUserRepository testUserRepository;

    public void saveUserProfile(UserRequest userRequest){

        LocalDateTime localDateTime = LocalDateTime.now();

        Integer testOxygen = 100;

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

    public Test saveTest(TestRequest testRequest){

        Test test = Test.builder()
                .title(testRequest.getTitle())
                .content(testRequest.getContent())
                .build();

        testUserRepository.save(test);

        return test;

    }
}
