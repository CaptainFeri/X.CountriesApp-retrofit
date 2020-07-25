package com.example.xcountriesapp_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.xcountriesapp_retrofit.model.Example;
import com.example.xcountriesapp_retrofit.service.GetCountryDataService;
import com.example.xcountriesapp_retrofit.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Example> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExampleList= new ArrayList<>();

        GetCountryDataService service = RetrofitInstance.getService();
        service.getAllCountries().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()){
                    mExampleList = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
    }
}