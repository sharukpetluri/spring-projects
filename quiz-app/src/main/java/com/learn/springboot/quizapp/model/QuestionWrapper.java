package com.learn.springboot.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class QuestionWrapper {
    private int qid;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
