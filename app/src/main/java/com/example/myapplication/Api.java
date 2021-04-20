package com.example.myapplication;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("https://fetch-hiring.s3.amazonaws.com/").build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }
}
