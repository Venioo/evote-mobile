package com.example.evote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evote.R;
import com.example.evote.model.response.Survey;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SurveyListAdapter extends RecyclerView.Adapter<SurveyListAdapter.ViewHolder> {

    private List<Survey> surveysList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public SurveyListAdapter(Context context, List<Survey> surveysList) {
        this.mInflater = LayoutInflater.from(context);
        this.surveysList = surveysList;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.survey_list_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Survey survey = surveysList.get(position);
        holder.myTextView.setText(survey.getTitle());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return surveysList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Survey getItem(int id) {
        return surveysList.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}