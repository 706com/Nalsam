package com.example.nalsam.airquality.service;

import com.example.nalsam.airquality.domain.StationLocation;
import com.example.nalsam.airquality.dto.AirQualityInfo;
import com.example.nalsam.airquality.repository.StationLocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final com.example.nalsam.airquality.api.AirQualityApiCaller AirQualityApiCaller;
    private final StationLocationService stationLocationService;

    @Cacheable(value = "airQualityCache", key = "#latitude + '_' + #longitude+'_'+#dateHourString")
    public AirQualityInfo getAirQualityInfo(Double latitude, Double longitude,String dateHourString ) {

        StationLocation nearestStation = findNearestStation(latitude, longitude);
        // 1. 642개 측정소명에서 가장 가까운 측정소명의 주소(sidoName) 추출
        // 2. 해당 주소로 searchByGu : sidoName을 통한 API 호출
        String sidoCode = nearestStation.getAddress().substring(0,2);
        var airQualityInfo = AirQualityApiCaller.getAir(sidoCode);
        // 뽑아온 여러개의 지역명 중 측정소명으로 최종 추출
        return airQualityInfo.searchByGu(nearestStation.getStationName());
    }
    public StationLocation findNearestStation(Double latitude, Double longitude){
        List<StationLocation> stationLocations = stationLocationService.getAllStationLocations();
        StationLocation nearestStation = null;
        double minDistance = Double.MAX_VALUE;


        for (StationLocation location : stationLocations) {
            double distance = calculateDistance(latitude, longitude, location.getLatitude(), location.getLongitude());
            if (distance < minDistance) {
                minDistance = distance;
                nearestStation = location;
            }
        }
//        log.info(nearestStation.getStationName()+" "+nearestStation.getAddress());
        return nearestStation;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c;

        return distance;
    }
}
