package com.example.nalsam.convergence.service;

import com.example.nalsam.convergence.dto.ConvergenceData;
import com.example.nalsam.convergence.dto.ConvergenceRequest;
import com.example.nalsam.convergence.dto.ConvergenceResponse;
import com.example.nalsam.convergence.dto.StatusScore;
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

    public ConvergenceResponse measureConvergenceScore(ConvergenceData convergenceData){
        ConvergenceResponse convergenceResponse;

        StatusScore statusScore = new StatusScore(convergenceData.getAge(),convergenceData.getSymtom());
        HealthScore healthScore = new HealthScore(convergenceData.getHeartRate(),convergenceData.getOxygenSaturation());
        WeatherScore weatherScore = new WeatherScore(convergenceData.getTemperature(),convergenceData.getHumidity(),convergenceData.getPrecipitation());
        AirQualityScore airQualityScore = new AirQualityScore(convergenceData.getPm10Grade(),convergenceData.getPm25Grade(),convergenceData.getSo2Grade(),
                convergenceData.getO3Grade(),convergenceData.getNo2Grade(),convergenceData.getCoGrade());

        int convergenceScore = 0;
        convergenceScore += statusScore.measureStatusScore();
        convergenceScore += healthScore.measureHealthScore();
        convergenceScore += weatherScore.measureWeatherScore();
        convergenceScore += airQualityScore.measureWeatherScore();

        convergenceResponse = new ConvergenceResponse(convergenceScore);
        return  convergenceResponse;
    }

}
