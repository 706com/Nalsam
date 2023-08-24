package com.example.nalsam.weather.controller;

import com.example.nalsam.airquality.service.AirQualityService;


import com.example.nalsam.weather.domain.LocationInfo;
import com.example.nalsam.weather.dto.WeatherDto;
import com.example.nalsam.weather.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final AirQualityService airQualityService;
    private final CurrentWeatherService currentWeatherService;

    @GetMapping("")
    public WeatherDto getCurrentWeatherInfo(@RequestParam(required = false) Double latitude,
                                            @RequestParam(required = false) Double longitude){
        if(latitude !=null && longitude !=null){
            LocationInfo nearestLocation = currentWeatherService.findNearestLocation(latitude,longitude);
            String nx = nearestLocation.getNx();
            String ny = nearestLocation.getNy();
            String sido = nearestLocation.getSido();
            String gu = nearestLocation.getGu();
            if(nearestLocation !=null){
                return currentWeatherService.getCurrentWeatherInfo(nx,ny,sido,gu);
            }
            else return null;

        }
        return currentWeatherService.getCurrentWeatherInfo(null,null,null,null);
    }
}
