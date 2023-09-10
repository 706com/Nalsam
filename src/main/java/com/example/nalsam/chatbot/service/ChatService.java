package com.example.nalsam.chatbot.service;

import com.example.nalsam.chatbot.dto.request.AirQualityRequest;
import com.example.nalsam.chatbot.dto.request.HealthRequest;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getChatResponse(HealthRequest healthRequest) {

        // 받은 정보로 질문 생성
        String question = "현재 나의 체내 산소포화도가 " +
                healthRequest.getOxyzenSaturation() + "%이며 " +
                "심박수는 " + healthRequest.getHeartRate() + "인데, 어떤 상태인지 자세히 알려줘";

        // Chat-GPT에게 질문 전송하여 응답 받기
        String response = chatgptService.sendMessage(question);
        return response;
    }
    public String getChatResponse(AirQualityRequest airQualityRequest) {

        // 받은 정보로 질문 생성
        String question ="현재 대기질이 so2:";

        // Chat-GPT에게 질문 전송하여 응답 받기
        String response = chatgptService.sendMessage(question);
        return response;
    }

}