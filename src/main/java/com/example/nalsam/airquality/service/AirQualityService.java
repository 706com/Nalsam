package com.example.nalsam.airquality.service;

import com.example.nalsam.airquality.dto.AirQualityDTO;
import com.example.nalsam.airquality.dto.AirQualityInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final com.example.nalsam.airquality.api.AirQualityApiCaller AirQualityApiCaller;

    public AirQualityInfo getAirQualityInfo(String sidoCode,String gu) {

//        var airQualityInfo = AirQualityApiCaller.getAirQuality(sidoCode);
        var airQualityInfo = AirQualityApiCaller.getAir(sidoCode);

        if(gu.equals("all")==false){
            return airQualityInfo.searchByGu(gu);
        }
        return airQualityInfo;
    }
}
