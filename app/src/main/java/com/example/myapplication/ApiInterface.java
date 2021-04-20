package com.example.myapplication;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {

    @GET("/hiring.json")
    public void getItemsList(Callback<List<ItemListResponse>> callback);

}
