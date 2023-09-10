package com.example.nalsam.chatbot.dto.request;

import lombok.Getter;

@Getter
public class HealthRequest {

    private String keyword;
    private int heartRate;
    private int oxyzenSaturation;

}
