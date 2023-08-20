package com.example.nalsam.weather.service;

import com.example.nalsam.weather.api.CurrentWeatherApiCaller;
import com.example.nalsam.weather.dto.CurrentWeatherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final CurrentWeatherApiCaller currentWeatherApiCaller;

    public CurrentWeatherDTO.GetCurrentWeatherResponse getCurrentWeatherInfo() {

        LocalDateTime dateTime = LocalDateTime.now();

        String date = String.valueOf(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        String time = String.valueOf(dateTime.format(DateTimeFormatter.ofPattern("HH"))+"00");

        System.out.println("date : "+date);
        System.out.println("time : "+time);


        var currentWeatherInfo = currentWeatherApiCaller.getCurrentWeather(date,time,"55","127");
        return currentWeatherInfo;
    }
}
