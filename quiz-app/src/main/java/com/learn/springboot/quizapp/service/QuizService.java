package com.learn.springboot.quizapp.service;

import com.learn.springboot.quizapp.model.Question;
import com.learn.springboot.quizapp.model.QuestionWrapper;
import com.learn.springboot.quizapp.model.Quiz;
import com.learn.springboot.quizapp.model.userResponse;
import com.learn.springboot.quizapp.repository.QuestionDao;
import com.learn.springboot.quizapp.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDao questionDao;

    public String createQuiz(String category, Integer numQ, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionDao.findRandomQuestionsByCategory(category,numQ));

        quizdao.save(quiz);
        return "Quiz created";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer quizId) {
        Optional<Quiz> quiz = quizdao.findById(quizId);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getQid(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return questionsForUser;

    }

    public Integer calculateScore(Integer id, List<userResponse> responses) {

       Optional<Quiz> quiz = quizdao.findById(id);
       List<Question> questions = quiz.get().getQuestions();
        int rightAns = 0;
        int i = 0;
        for(userResponse response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer())) {

                rightAns++;
            }
            i++;

        }

        return rightAns;

    }
}
