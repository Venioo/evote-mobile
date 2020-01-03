package com.example.evote.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evote.R;

public class RegistrationActivity extends BaseActivity {

    private EditText userName, userPassword;
    private Button registerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUIViews();

        registerButton.setOnClickListener(v -> {
            if (validate()) {
                Toast.makeText(v.getContext(), "Registration successful", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_registration;
    }

    private void setupUIViews() {
        this.userName = findViewById(R.id.username);
        this.userPassword = findViewById(R.id.password);
        this.registerButton = findViewById(R.id.register);
    }

    private boolean validate() {
        boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            //TODO Zapytanie backendu o sprawdzenie danych, czy sie nie powtarza itp.
            result = true;
        }
        return result;
    }
}
