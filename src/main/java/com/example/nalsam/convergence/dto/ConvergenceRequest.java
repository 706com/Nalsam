package com.example.nalsam.convergence.dto;

import com.example.nalsam.airquality.util.AirQualityGrade;
import lombok.Getter;

@Getter
public class ConvergenceRequest {

    //대기질 데이터
    private String pm10Grade ;  //미세먼지
    private String pm25Grade;   //
    private String so2Grade ;
    private String o3Grade ;
    private String no2Grade;
    private String coGrade;

    //날씨 데이터
    private Double temperature; //기온
    private int precipitation; //강수량
    private int Humidity;       //습도

    //사용자 데이터
    private String age; //나이
    private String heartRate; //심박수
    private String oxygenSaturation; // 산소포화도
    private String Symtom; //증상


}
