package com.example.evote.endpoint;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;
}
