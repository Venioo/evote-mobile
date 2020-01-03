package com.example.evote.endpoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppEndpoint {

    private static Retrofit objRetrofit;

    private static final String baseUrl = "https://jsonplaceholder.typicode.com/";

    public static ApiEndpointInterface getClient() {
        if (objRetrofit == null) {
            objRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return objRetrofit.create(ApiEndpointInterface.class);
    }
}
