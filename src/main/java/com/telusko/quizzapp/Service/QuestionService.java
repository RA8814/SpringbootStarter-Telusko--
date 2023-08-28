package com.telusko.quizzapp.Service;

import com.telusko.quizzapp.Dao.QuestionDao;
import com.telusko.quizzapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findQuestionsByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            Question save = questionDao.save(question);
            return new ResponseEntity<>(save.toString(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error! ", HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteByID(Integer id) {
        Optional<Question> question = questionDao.findById(id);
        if (!question.isEmpty()){
            questionDao.deleteById(id);
            return question.toString();
        }
     return "No such question found in DB";
    }
}
