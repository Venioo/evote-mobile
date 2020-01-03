package com.example.evote.model.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Survey implements Serializable {
    private String id;
    private String title;
    private List<Question> questionList;
}
