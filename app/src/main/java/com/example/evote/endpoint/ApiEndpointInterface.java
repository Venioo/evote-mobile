package com.example.evote.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
}
