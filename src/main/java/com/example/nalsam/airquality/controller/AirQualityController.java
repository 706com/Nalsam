package com.example.nalsam.airquality.controller;

import com.example.nalsam.airquality.domain.StationLocation;
import com.example.nalsam.airquality.dto.AirQualityInfo;
import com.example.nalsam.airquality.service.AirQualityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/air")
public class AirQualityController {
    private final AirQualityService airQualityService;
    @GetMapping("")
    public AirQualityInfo getAirQualityInfo(@RequestParam(required = false) Double latitude,
                                            @RequestParam(required = false) Double longitude) {
        if (latitude != null && longitude != null) {
            StationLocation nearestStation = airQualityService.findNearestStation(latitude, longitude);
            if (nearestStation != null) {
                System.out.println("Nearest Station Name: " + nearestStation.getStationName());
                System.out.println("Nearest Station Latitude: " + nearestStation.getLatitude());
                System.out.println("Nearest Station Longitude: " + nearestStation.getLongitude());
                System.out.println("--------------------------------");
                return airQualityService.getAirQualityInfo(nearestStation.getLatitude(), nearestStation.getLongitude());
            } else {
                // Handle case when no nearest station is found
                return null;
            }
        } else {
            // Handle case when latitude and longitude are not provided
            return airQualityService.getAirQualityInfo(null, null);
        }
    }
}