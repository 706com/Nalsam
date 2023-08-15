package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.domain.Test;
import user.domain.TestRequest;
import user.domain.User;
import user.domain.UserRequest;
import user.repository.TestUserRepository;
import user.repository.UserRepository;

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
