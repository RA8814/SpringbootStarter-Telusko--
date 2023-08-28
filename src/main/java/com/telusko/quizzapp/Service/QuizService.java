package com.telusko.quizzapp.Service;

import com.telusko.quizzapp.Dao.QuestionDao;
import com.telusko.quizzapp.Dao.QuizDao;
import com.telusko.quizzapp.Model.Question;
import com.telusko.quizzapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        List<Question> questionList = questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizDao.save(quiz);

        return new ResponseEntity<>(quiz.toString(), HttpStatus.CREATED);
    }
}
