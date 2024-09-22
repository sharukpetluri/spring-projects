package com.learn.springboot.quizapp.controller;

import com.learn.springboot.quizapp.model.Question;
import com.learn.springboot.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@RequestParam("cat") String category) {
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return new ResponseEntity<>("Question Added", HttpStatus.CREATED);
    }

    @GetMapping("{qid}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer qid) {
        return new ResponseEntity<>(questionService.getQuestionById(qid), HttpStatus.FOUND);
    }

    @PutMapping("{qid}/update")
    public ResponseEntity<Map<Integer, String>> updateQuestionById(@PathVariable Integer qid, @RequestBody Question updatedQuestion) {
        return new ResponseEntity<>(questionService.updateQuestionById(qid, updatedQuestion), HttpStatus.OK);
    }

    @DeleteMapping("{qid}/delete")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Integer qid) {
        questionService.deleteQuestionById(qid);
        return new ResponseEntity<>("Question with Id " + qid + " deleted successfully", HttpStatus.OK);
    }


}
