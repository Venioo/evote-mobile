package com.example.evote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evote.R;
import com.example.evote.endpoint.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private EditText userName, userPassword;
    private Button loginButton;
    private TextView userRegistrationLink;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUIViews();
        Call<List<Post>> posts = retrofit.getPosts();
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> body = response.body();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });

        userRegistrationLink.setMovementMethod(LinkMovementMethod.getInstance());

        loginButton.setOnClickListener(v -> {
            if (validate()) {
                Intent intent = new Intent(v.getContext(), SurveyListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        userRegistrationLink.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void setupUIViews() {
        this.userName = findViewById(R.id.username);
        this.userPassword = findViewById(R.id.password);
        this.loginButton = findViewById(R.id.login);
        this.userRegistrationLink = findViewById(R.id.registration);
    }

    private boolean validate() {
        boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            //TODO Zapytanie backendu o sprawdzenie danych
            result = true;
        }
        return result;
    }
}
