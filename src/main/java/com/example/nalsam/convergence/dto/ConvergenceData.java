package com.example.nalsam.convergence.dto;

import lombok.Getter;

@Getter
public class ConvergenceData {
    //대기질 데이터
    private String pm10Grade ;  //미세먼지
    private String pm25Grade;   //초미세먼지
    private String so2Grade ;   //아황산가스
    private String o3Grade ;    //오존
    private String no2Grade;    //이산화질소
    private String coGrade;     //일산화탄소

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
