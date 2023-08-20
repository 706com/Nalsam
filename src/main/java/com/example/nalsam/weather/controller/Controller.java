package com.example.nalsam.weather.controller;

import com.example.nalsam.airquality.service.AirQualityService;
import com.example.nalsam.database.LocationInfoDTO;
import com.example.nalsam.database.LocationInfoRepository;

import com.example.nalsam.weather.dto.CurrentWeatherDTO;
import com.example.nalsam.weather.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {
    private final AirQualityService airQualityService;
    private final CurrentWeatherService currentWeatherService;

    private final LocationInfoRepository locationInfoRepository;

    @GetMapping("/test")
    public List<LocationInfoDTO> findAllMember(){
        return locationInfoRepository.findAll();
    }

    @GetMapping("/find")
    public List<LocationInfoDTO> findBySido(){
        return locationInfoRepository.findByPointXAndPointY(60,127);
    }

    @GetMapping("/weather")
    public CurrentWeatherDTO.GetCurrentWeatherResponse getCurrentWeatherInfo(){
        return currentWeatherService.getCurrentWeatherInfo();
    }
}
