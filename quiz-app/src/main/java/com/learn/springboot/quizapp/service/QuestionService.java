package com.learn.springboot.quizapp.service;

import com.learn.springboot.quizapp.model.Question;
import com.learn.springboot.quizapp.repository.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    @Autowired
    public QuestionDao questionDao;


    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionDao.save(question);
    }

    public Question getQuestionById(Integer qid) {
        return questionDao.findById(qid).orElse(null);
    }

    public Map<Integer, String> updateQuestionById(Integer qid, Question updatedQuestion) {
        Map<Integer,String> responseMap = new HashMap<>();

        Question existingQuestion = questionDao.findById(qid).orElseThrow(() -> new RuntimeException("Question with Id " + qid + " not found"));
        existingQuestion.setQid(updatedQuestion.getQid());
        existingQuestion.setQuestion(updatedQuestion.getQuestion());
        existingQuestion.setOption1(updatedQuestion.getOption1());
        existingQuestion.setOption2(updatedQuestion.getOption2());
        existingQuestion.setOption3(updatedQuestion.getOption3());
        existingQuestion.setOption4(updatedQuestion.getOption4());
        existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
        existingQuestion.setCategory(updatedQuestion.getCategory());

        questionDao.save(existingQuestion);
        responseMap.put(qid, "Question with Id " + qid + " updated successfully");
        return responseMap;

    }

    public void deleteQuestionById(Integer qid) {
        questionDao.deleteById(qid);
    }
}
