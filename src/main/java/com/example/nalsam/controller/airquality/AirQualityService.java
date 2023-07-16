package com.example.nalsam.controller.airquality;

import com.example.nalsam.controller.airquality.AirQualityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final com.example.nalsam.controller.airquality.AirQualityApiCaller AirQualityApiCaller;

    public AirQualityDTO.GetAirQualityResponse getAirQualityInfo(String sidoCode) {

        var airQualityInfo = AirQualityApiCaller.getAirQuality(sidoCode);
        return airQualityInfo;
    }
}
