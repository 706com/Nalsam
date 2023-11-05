package com.example.nalsam.convergence.service;

public class AirQualityScore {
    private String pm10Grade;  // 미세먼지
    private String pm25Grade;  // 초미세먼지
    private String so2Grade;   // 아황산가스
    private String o3Grade;    // 오존
    private String no2Grade;   // 이산화질소
    private String coGrade;    // 일산화탄소
    private String symtom;
    private int airQualityScore;

    public AirQualityScore(String pm10Grade, String pm25Grade, String so2Grade, String o3Grade, String no2Grade,
                           String coGrade) {
        this.pm10Grade = pm10Grade;
        this.pm25Grade = pm25Grade;
        this.so2Grade = so2Grade;
        this.o3Grade = o3Grade;
        this.no2Grade = no2Grade;
        this.coGrade = coGrade;
    }

    public int measureAirQualityScore() {
        airQualityScore = 0;

        // 미세먼지, 초미세먼지, 아황산가스, 오존, 이산화질소, 일산화탄소에 대한 등급에 따라 점수 계산
        airQualityScore += getGradeScore(pm10Grade);
        airQualityScore += getGradeScore(pm25Grade);
        airQualityScore += getGradeScore(so2Grade);
        airQualityScore += getGradeScore(o3Grade);
        airQualityScore += getGradeScore(no2Grade);
        airQualityScore += getGradeScore(coGrade);

        return airQualityScore;
    }

    private int getGradeScore(String grade) {
        switch (grade) {
            case "좋음":
                return 5;
            case "보통":
                return 4;
            case "나쁨":
                return 2;
            case "매우나쁨":
                return 1;
            default:
                return 0; // 등급이 정의되지 않은 경우 0점 처리
        }
    }

    public static void main(String[] args) {
        AirQualityScore airQuality = new AirQualityScore("좋음", "매우나쁨", "좋음", "좋음", "매우나쁨", "좋음");
        int score = airQuality.measureAirQualityScore();
        System.out.println("대기질 점수: " + score);
    }
}