package com.example.nalsam.airquality.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirQualityApi {

    @GET("getCtprvnRltmMesureDnsty")
    Call<AirQualityData.GetAirQualityResponse> getAirQuality(@Query("serviceKey") String serviceKey,
                                                             @Query("returnType") String returnType,
                                                             @Query("numOfRows") int numOfRows,
                                                             @Query("pageNo") int pageNo,
                                                             @Query("ver") String ver,
                                                             @Query("sidoName") String sidoCode);
}



/*
    String SERVICE_KEY = "~~~~~~~~~~~~~~~~~~~~";

    //@GET("serviceKey="+ serviceKey + "&returnType=json&numOfRows=100&pageNo=1&sidoName=" + sidoName + "&ver=1.0")
    @GET("getCtprvnRltmMesureDnsty?serviceKey="+ SERVICE_KEY + "&returnType=json&numOfRows=700&pageNo=1&ver=1.0")

    Call<AirQualityDTO.GetAirQualityResponse> getAirQuality(@Query("sidoName") String sidoCode);
    */

    /*
    "속성 값은 상수여야 합니다" 오류가 발생하는 이유는 Java의 주석에 상수 값이 필요하고
    상수가 아닌 변수(예: SERVICE_KEY)를 주석의 속성 값으로 사용할 수 없기 때문입니다.
    이 문제를 해결하려면 인터페이스 내에서 직접 @Value 주석을 사용할 수 없으며
    @GET 주석에서 사용될 것으로 예상합니다.
    대신 SERVICE_KEY 값을 메소드 매개변수로 getAirQuality 메소드에 전달해야 합니다
    다음은 SERVICE_KEY를 메소드 매개변수로 사용하도록 AirQualityApi 인터페이스를 수정하는 방법입니다.
     */