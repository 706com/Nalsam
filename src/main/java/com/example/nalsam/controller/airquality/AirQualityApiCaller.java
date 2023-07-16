package com.example.nalsam.controller.airquality;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Slf4j
@Component
public class AirQualityApiCaller {
    private final com.example.nalsam.controller.airquality.AirQualityApi AirQualityApi;

    public AirQualityApiCaller() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        this.AirQualityApi = retrofit.create(AirQualityApi.class);
    }

    public AirQualityDTO.GetAirQualityResponse getAirQuality(String sidoCode) {
        try {
            var call = AirQualityApi.getAirQuality(sidoCode);
            var response = call.execute().body();

            if (response == null || response.getResponse() == null) {
                throw new RuntimeException(" getAirQuality 응답값이 존재하지 않습니다.");
            }

            if (response.getResponse().isSuccess()) {
                log.info(response.toString());
                System.out.println("@@@@@@@@@@@");
                return response;
            }

            throw new RuntimeException(" getAirQuality 응답이 올바르지 않습니다. header=" + response.getResponse().getHeader());

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(" getAirQuality API error 발생! errorMessage=" + e.getMessage());
        }
    }
}
