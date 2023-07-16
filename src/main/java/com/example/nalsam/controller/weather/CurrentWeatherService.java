package com.example.nalsam.controller.weather;

import com.example.nalsam.controller.airquality.AirQualityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final CurrentWeatherApiCaller currentWeatherApiCaller;

    public CurrentWeatherDTO.GetCurrentWeatherResponse getCurrentWeatherInfo() {

        LocalDateTime dateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");

        String date = String.valueOf(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        String time = String.valueOf(dateTime.format(DateTimeFormatter.ofPattern("HH"))+"00");

        System.out.println("date : "+date);
        System.out.println("time : "+time);

//        System.out.println(dateTime.format(formatter));

        var currentWeatherInfo = currentWeatherApiCaller.getCurrentWeather(date,time,"55","127");
        return currentWeatherInfo;
    }
}
