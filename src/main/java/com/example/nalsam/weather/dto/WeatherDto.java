package com.example.nalsam.weather.dto;

import com.example.nalsam.weather.util.WeatherCategory;
import com.example.nalsam.weather.util.WeatherCategoryUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WeatherDto {
    private String sido;
    private String gu;
    private List<WeatherInfo> weatherInfoList;

    @Getter
    public static class WeatherInfo{
        private WeatherCategory category;
        private Double value;

        public WeatherInfo(String category,Double value){
            this.value = value;
            this.category = WeatherCategoryUtil.getCategory(category);
        }
    }
}