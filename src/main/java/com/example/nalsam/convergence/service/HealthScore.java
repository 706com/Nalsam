package com.example.nalsam.convergence.service;

public class HealthScore {

    private Integer heartRate; //심박수

    private Integer oxygenSaturation; // 산소포화도

    private Integer score;

    public HealthScore(Integer heartRate, Integer oxygenSaturation) {
        this.heartRate = heartRate;
        this.oxygenSaturation = oxygenSaturation;
        this.score = 0;
    }

    public int measureHealthScore(){
        measureHeartRateScore();
        measureOxygenSaturationScore();
        return this.score;
    }

    private void measureHeartRateScore(){
        if(heartRate>=100){
            score+=5;
        }
        else if(heartRate<60){
            score+=5;
        }
    }
    private void measureOxygenSaturationScore(){
        if(90<=oxygenSaturation && oxygenSaturation<=94){
            this.score += 10;
        }
        else if(oxygenSaturation<90){
            this.score += 20;
        }
    }
}
