package com.example.evote.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evote.R;

public class AddSurveyActivity extends BaseActivity {

    private EditText surveysId;
    private Button confirmButton;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_add_survey;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUIViews();

        confirmButton.setOnClickListener(v -> {
            Toast.makeText(this, "DODANO ANKIETE", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void setupUIViews() {
        this.surveysId = findViewById(R.id.surveysId);
        this.confirmButton = findViewById(R.id.confirm);
    }
}

