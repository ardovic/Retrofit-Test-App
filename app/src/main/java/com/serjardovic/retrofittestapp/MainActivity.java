package com.serjardovic.retrofittestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<PageData> {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;

    private PageData pageData;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        try {

            JSONObject paramObject = new JSONObject();
            paramObject.put("page", 1);

            Log.d("HEX", paramObject.toString());

            Call<PageData> call = apiInterface.getPageData(paramObject.toString());

            call.enqueue(this);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onResponse(Call<PageData> call, Response<PageData> response) {

        pageData = (PageData) response.body();

        Log.d("HEX", response.body()+"");
        Log.d("HEX", response.toString());

        Log.d("HEX", ""+pageData.getNextPage());
        Log.d("HEX", ""+pageData.getCurrentPage());




        //recyclerAdapter = new RecyclerAdapter(pageData);
        //recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onFailure(Call<PageData> call, Throwable t) {

    }
}
