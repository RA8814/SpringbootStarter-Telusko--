package com.telusko.quizzapp.Controller;

import com.telusko.quizzapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create{category}{numQ}{title}")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
//        return new ResponseEntity<>("I am here " + category + " " + numQ + " " + title , HttpStatus.OK);
        return quizService.createQuiz(category, numQ, title);
    }
}
