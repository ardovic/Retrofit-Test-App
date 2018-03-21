package com.serjardovic.retrofittestapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/weather")
    Call<WeatherData> getWeatherData(@Query("q") String cityAndCountry,
                               @Query("appid") String appid);

}
