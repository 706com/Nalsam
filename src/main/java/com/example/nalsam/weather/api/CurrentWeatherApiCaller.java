package com.example.nalsam.weather.api;

import com.example.nalsam.weather.dto.CurrentWeatherDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Slf4j
@Component
public class CurrentWeatherApiCaller {
    private final CurrentWeatherApi CurrentWeatherApi;

    @Value("${CURRENT-WEATHER-KEY}")
    private String SERVICE_KEY;

    public CurrentWeatherApiCaller() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        this.CurrentWeatherApi = retrofit.create(CurrentWeatherApi.class);
    }

    public CurrentWeatherDTO.GetCurrentWeatherResponse getCurrentWeather(String date , String time , String nx , String ny) {             // Todo : nx,ny 작업
        try {
            var call = CurrentWeatherApi.getCurrentWeather(SERVICE_KEY,"json",1,100,date, time, nx, ny);               // Todo : nx,ny 작업
            var response = call.execute().body();

            if (response == null || response.getResponse() == null) {
                throw new RuntimeException(" Weather 응답값이 존재하지 않습니다.");
            }

            if (response.getResponse().isSuccess()) {
                log.info(response.toString());
                System.out.println("SKrrrrrrrrrrrrrrr");
                return response;
            }

            throw new RuntimeException(" Weather 응답이 올바르지 않습니다. header=" + response.getResponse().getHeader());

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(" Weather API error 발생! errorMessage=" + e.getMessage());
        }
    }
}
