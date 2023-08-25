package com.telusko.quizzapp.Service;

import com.telusko.quizzapp.Dao.QuestionDao;
import com.telusko.quizzapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
