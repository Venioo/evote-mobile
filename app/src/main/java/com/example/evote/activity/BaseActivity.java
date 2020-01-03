package com.example.evote.activity;

import android.os.Bundle;

import com.example.evote.endpoint.ApiEndpointInterface;
import com.example.evote.endpoint.AppEndpoint;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected ApiEndpointInterface retrofit = AppEndpoint.getClient();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
    }

    protected abstract int getLayoutResourceId();

}
