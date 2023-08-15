package com.example.nalsam.user.dto.request;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestRequest {

    private String title;

    private String content;

    @Builder
    public TestRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
