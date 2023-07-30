package com.example.nalsam.airquality.service;

import com.example.nalsam.airquality.dto.AirQualityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final com.example.nalsam.airquality.api.AirQualityApiCaller AirQualityApiCaller;

    public AirQualityDTO.GetAirQualityResponse getAirQualityInfo(String sidoCode) {

        var airQualityInfo = AirQualityApiCaller.getAirQuality(sidoCode);
        return airQualityInfo;
    }
}
