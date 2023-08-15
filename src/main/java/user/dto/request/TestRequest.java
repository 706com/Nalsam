package user.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class TestRequest {

    private String title;

    private String content;

    @Builder
    public TestRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
