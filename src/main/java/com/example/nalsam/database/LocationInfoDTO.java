package com.example.nalsam.database;

import lombok.*;

import javax.persistence.*;

@Getter // getter 메소드 생성
@Entity(name="location_info") // 테이블 명을 작성
public class LocationInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double location_code;

    private String sido;
    private String gu;

    @Column(name="point_x") //database table 이름이랑 맵핑
    private int pointX;

    @Column(name="point_y")
    private int pointY;
}
