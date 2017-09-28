package com.serjardovic.retrofittestapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("images.php")
    Call<PageData> getPageData(@Body String body);

}
