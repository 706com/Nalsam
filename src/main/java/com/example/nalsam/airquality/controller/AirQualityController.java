package com.example.nalsam.airquality.controller;

import com.example.nalsam.airquality.dto.AirQualityDTO;
import com.example.nalsam.airquality.service.AirQualityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/air")
public class AirQualityController {
    private final AirQualityService airQualityService;

    @GetMapping("/{sidoCode}")
    public AirQualityDTO.GetAirQualityResponse getAirQualityInfo(@PathVariable("sidoCode") String sidoCode) {
        return airQualityService.getAirQualityInfo(sidoCode);
    }

}
