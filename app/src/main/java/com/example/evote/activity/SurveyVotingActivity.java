package com.example.evote.activity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.evote.R;
import com.example.evote.model.response.Option;
import com.example.evote.model.response.Question;
import com.example.evote.model.response.Survey;

public class SurveyVotingActivity extends BaseActivity {

    private TextView questionTitle;
    private ListView listView;
    private Button previousButton;
    private Button nextButton;

    private Survey survey;

    private int questionIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.previousButton = findViewById(R.id.previous);
        this.nextButton = findViewById(R.id.next);
        this.questionTitle = findViewById(R.id.questionTitle);
        this.listView = findViewById(R.id.listView);

        this.survey = (Survey) getIntent().getSerializableExtra("survey");
        setQuestionContent();

        previousButton.setText("Back");
        previousButton.setOnClickListener(v -> {
            if (questionIndex == 0) {
                finish();
            } else {
                questionIndex--;
                manageButtonTexts();
                setQuestionContent();
            }
        });

        nextButton.setOnClickListener(v -> {
            if (questionIndex == survey.getQuestionList().size() - 1) {
                // TODO send result
                finish();
            } else {
                questionIndex++;
                manageButtonTexts();
                setQuestionContent();
            }
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_survey;
    }

    private void setQuestionContent() {
        Question question = survey.getQuestionList().get(this.questionIndex);
        this.questionTitle.setText(question.getText());
        ArrayAdapter<Option> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, question.getOptions());
        this.listView.setAdapter(adapter);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        this.listView.setItemChecked(question.getSelectedOptionIndex(), true);
        this.listView.setOnItemClickListener((parent, view, position, id) -> survey.getQuestionList().get(questionIndex).setSelectedOptionIndex(position));
    }

    private void manageButtonTexts() {
        if (questionIndex == survey.getQuestionList().size() - 1) {
            nextButton.setText("Finish");
        } else {
            nextButton.setText("Next");
        }

        if (questionIndex == 0) {
            previousButton.setText("Back");
        } else {
            previousButton.setText("Previous");
        }
    }

}
