package com.example.nalsam.weather.util;

import static com.example.nalsam.weather.util.WeatherCategory.*;

public class WeatherCategoryUtil {
    private WeatherCategoryUtil(){

    }
    public static WeatherCategory getCategory(String category){
        if(category.equals("T1H")){
            return 기온;
        }
        if(category.equals("RN1")){
            return 한시간강수량;
        }
        if(category.equals("REH")){
            return 습도;
        }
        if(category.equals("PTY")){
            return 강수형태;
        }
        if(category.equals("WSD")){
            return 풍속;
        }
        return 없음;
    }



}
