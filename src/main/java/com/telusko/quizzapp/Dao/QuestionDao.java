package com.telusko.quizzapp.Dao;

import com.telusko.quizzapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
}
