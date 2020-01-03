package com.example.evote.model.response;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Option implements Serializable {
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
