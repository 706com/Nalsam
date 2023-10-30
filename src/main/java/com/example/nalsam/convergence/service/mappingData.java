package com.example.nalsam.convergence.service;

import com.example.nalsam.convergence.dto.ConvergenceData;
import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.user.domain.Users;
import com.example.nalsam.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class mappingData {
    private UserService userService;

    public ConvergenceData colletConvergenceData(ConvergenceRequest convergenceRequest){
        String loginId = convergenceRequest.getLoginId();
        Users user = userService.findUserByLoginId(loginId);

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
                .age(user.getBirthDate())
                .heartRate(user.getHeartRate())
                .oxygenSaturation(user.getOxygenSaturation())
                .symtom(user.getSymptom())
                .build();
    }
}
