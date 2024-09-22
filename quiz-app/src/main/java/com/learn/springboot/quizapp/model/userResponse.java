package com.learn.springboot.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class userResponse {

    private int quesId;
    private String response;
}
