package com.serjardovic.retrofittestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<WeatherData> {

    public static final String API_KEY = "1780541fd97c219bcb6b471152ad65c7";
    public static final String CITY_AND_COUNTRY = "Moscow,RU";

    @BindView(R.id.text)
    TextView textView;

    private WeatherData weather;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        Call<WeatherData> call = apiInterface.getWeatherData(CITY_AND_COUNTRY, API_KEY);
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

        weather = (WeatherData) response.body();

        textView.setText(weather.toString());
    }

    @Override
    public void onFailure(Call<WeatherData> call, Throwable t) {

    }
}
