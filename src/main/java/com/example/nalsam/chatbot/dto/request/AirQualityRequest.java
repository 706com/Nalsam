package com.example.nalsam.chatbot.dto.request;

import lombok.Getter;

@Getter
public class AirQualityRequest {
    private String keyword;

    private String so2Value;
    private String coValue;
    private String pm10Value;
    private String pm25Value;
    private String no2Value;
    private String o3Value;
}
