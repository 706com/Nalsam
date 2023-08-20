package weather.controller;

import com.example.nalsam.airquality.service.AirQualityService;
import com.example.nalsam.database.LocationInfoDTO;
import com.example.nalsam.database.LocationInfoRepository;
import weather.dto.CurrentWeatherDTO;
import weather.service.CurrentWeatherService;
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

//    @GetMapping("")
//    public AirQualityDto.GetAirQualityResponse getAirQualityInfo() {
//        return airQualityService.getAirQualityInfo();
//    }


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
