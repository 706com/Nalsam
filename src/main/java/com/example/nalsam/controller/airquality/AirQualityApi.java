package com.example.nalsam.controller.airquality;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirQualityApi {
    //디코딩 서비스키
    String serviceKey = "ebZTQ4iRgDlaQNNtqJ5A9RcdWIhNzGvnQFQxLCwXDgjX/pNKJ49cQjal7Otx6mIyZpr/GWQWvwieBTwSMcb40w==";
    //String sidoName = "서울";

    //@GET("serviceKey="+ serviceKey + "&returnType=json&numOfRows=100&pageNo=1&sidoName=" + sidoName + "&ver=1.0")
    @GET("getCtprvnRltmMesureDnsty?serviceKey="+ serviceKey + "&returnType=json&numOfRows=700&pageNo=1&ver=1.0")
    //Call = api데이터를 맵핑 시켜주는 것?
//    Call<AirQualityDto.GetAirQualityResponse> getAirQuality();

    Call<AirQualityDTO.GetAirQualityResponse> getAirQuality(@Query("sidoName") String sidoCode);
}

