package com.example.evote.model.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Question implements Serializable {
    @NonNull
    private String text;
    @NonNull
    private List<Option> options;
    private int selectedOptionIndex;
}

