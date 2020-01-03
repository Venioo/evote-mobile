package com.example.evote.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.evote.R;
import com.example.evote.adapter.SurveyListAdapter;
import com.example.evote.model.response.Option;
import com.example.evote.model.response.Question;
import com.example.evote.model.response.Survey;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SurveyListActivity extends BaseActivity implements SurveyListAdapter.ItemClickListener {

    SurveyListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Survey> surveysList = getSurveyDataMock();

        RecyclerView recyclerView = findViewById(R.id.rvSurveys);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SurveyListAdapter(this, surveysList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        ImageButton ib = findViewById(R.id.add_survey_button);
        ib.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddSurveyActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_survey_list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = new Intent(SurveyListActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?")
                    .setNegativeButton("No", dialogClickListener)
                    .setPositiveButton("Yes", dialogClickListener)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, SurveyVotingActivity.class);
        Survey item = adapter.getItem(position);
        intent.putExtra("survey", item);
        startActivity(intent);
    }

    //TODO mock
    private List<Survey> getSurveyDataMock() {
        Option option = new Option("odpowiedz a");
        Option option2 = new Option("odpowiedz b");
        Option option3 = new Option("odpowiedz c");
        Option option4 = new Option("odpowiedz d");


        Question question = new Question("pytanie 1", Arrays.asList(option, option2, option3, option4));
        Question question2 = new Question("pytanie 2", Arrays.asList(option, option2, option3, option4));

        Survey survey1 = new Survey("1", "Ankieta 1", Arrays.asList(question, question2));
        Survey survey2 = new Survey("2", "Ankieta 2", Arrays.asList(question, question2));

        return Arrays.asList(survey1, survey2);
    }
}