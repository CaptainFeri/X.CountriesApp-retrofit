package com.example.xcountriesapp_retrofit.service;

import com.example.xcountriesapp_retrofit.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    @GET("rest/v2/all")
    Call<List<Example>> getAllCountries();
}
