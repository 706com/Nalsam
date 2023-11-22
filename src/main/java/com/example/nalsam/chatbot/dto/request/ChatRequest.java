package com.example.nalsam.chatbot.dto.request;

import com.example.nalsam.chatbot.domain.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest implements Serializable {

    private String model;
    private List<Message> messages;
}