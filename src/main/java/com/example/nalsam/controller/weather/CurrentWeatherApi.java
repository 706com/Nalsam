//package com.example.nalsam.controller.weather;
//
//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Query;
//
//public interface CurrentWeatherApi {
//    //디코딩 서비스키
//    String serviceKey = "R7wL2RYTuUBizIPLQ0KMI4HRlHfs/e9wMoomK7bqFStjVM+kUjgP6pJRe/EOUVs36oPJkJfQ26BR9Fw9WHXBEw==";
////    String serviceKey = "R7wL2RYTuUBizIPLQ0KMI4HRlHfs%2Fe9wMoomK7bqFStjVM%2BkUjgP6pJRe%2FEOUVs36oPJkJfQ26BR9Fw9WHXBEw%3D%3D";
//
//    //@GET("serviceKey="+ serviceKey + "&returnType=json&numOfRows=100&pageNo=1&sidoName=" + sidoName + "&ver=1.0")
//    @GET("getUltraSrtNcst?serviceKey="+ serviceKey +
//            "&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20230714&base_time=0600&nx=55&ny=127")
//
//    //Call = api데이터를 맵핑 시켜주는 것?
//    Call<CurrentWeatherDTO.GetCurrentWeatherResponse> getCurrentWeather();
//
////    Call<AirQualityDTO.GetAirQualityResponse> getAirQuality(@Query("data_date") String date,
////                                                            @Query("base_time") String time,
////                                                            @Query("nx") Integer pointX,
////                                                            @Query("ny") Integer pointY);
//}

package com.example.nalsam.controller.weather;

import com.example.nalsam.controller.weather.CurrentWeatherDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.net.URLEncoder;


public interface CurrentWeatherApi {
//    String serviceKey = "R7wL2RYTuUBizIPLQ0KMI4HRlHfs/e9wMoomK7bqFStjVM+kUjgP6pJRe/EOUVs36oPJkJfQ26BR9Fw9WHXBEw==";
    String serviceKey = "R7wL2RYTuUBizIPLQ0KMI4HRlHfs%2Fe9wMoomK7bqFStjVM%2BkUjgP6pJRe%2FEOUVs36oPJkJfQ26BR9Fw9WHXBEw%3D%3D";

    @GET("getUltraSrtNcst?serviceKey="+ serviceKey + "&dataType=json&pageNo=1&numOfRows=100")
    Call<CurrentWeatherDTO.GetCurrentWeatherResponse> getCurrentWeather(@Query("base_date") String date,
                                                                        @Query("base_time") String time,
                                                                        @Query("nx")String nx,  //61
                                                                        @Query("ny")String ny); //125
}