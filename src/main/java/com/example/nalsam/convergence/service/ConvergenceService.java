package com.example.nalsam.convergence.service;

import com.example.nalsam.convergence.dto.ConvergenceData;
import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.user.domain.Users;
import com.example.nalsam.user.service.UserService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvergenceService {

    private UserService userService;

    public ConvergenceData colletConvergenceData(ConvergenceRequest convergenceRequest){
        String loginId = convergenceRequest.getLoginId();
        Users user = userService.findUserByLoginId(loginId);

        int age = calculateAge(user.getBirthDate());

        return ConvergenceData.builder()
                .pm10Grade(convergenceRequest.getPm10Grade())
                .pm25Grade(convergenceRequest.getPm25Grade())
                .so2Grade(convergenceRequest.getSo2Grade())
                .o3Grade(convergenceRequest.getO3Grade())
                .no2Grade(convergenceRequest.getNo2Grade())
                .coGrade(convergenceRequest.getCoGrade())
                .temperature(convergenceRequest.getTemperature())
                .precipitation(convergenceRequest.getPrecipitation())
                .humidity(convergenceRequest.getHumidity())
                .age(age)
                .heartRate(user.getHeartRate())
                .oxygenSaturation(user.getOxygenSaturation())
                .symtom(user.getSymptom())
                .build();
    }

    private int calculateAge(String birthDate){
        Integer userBirthYear = Integer.parseInt(birthDate.substring(0,4));
        Integer nowYear = LocalDate.now().getYear();

        return nowYear-userBirthYear;
    }

    // Todo : 데이터 가공
    // algorithm
    // 1. 데이터를 외부에서 받아온다. (Request)
    // 2. 1)if 질환
    //       1-1)if 대기질6가지 당 점수 측정(좋음 , 보통 , 나쁨 , 매우나쁨)  * 0, 1, 2, 3

    //       1-2)if 산소포화도 (정상(100~95) , 주의(94~90) , 저산소증(90이하)(-2))  tempScore -1
    //           1-2-1)if(대기질)
    //               tempScore * 몇배수
    //
    //    2)if 날씨
    //       기온 , 습도 , 강수량 따른 고정적 -1
    //
    //    3)나이 (유아동기0~15)-1 , 청년기(16~60) 0 , 노년기(61~) -2
    //       3-1)심박수 (보통 60~100 ,
//   provide천식Score(); -> 86
//   provide폐렴Socre();  -> 90   ->88

    public void measureConvergenceScore(ConvergenceData convergenceData){

    }

}
