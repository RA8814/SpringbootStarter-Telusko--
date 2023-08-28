package com.telusko.quizzapp.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Component
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @ManyToMany
    private List<Question> questions;
}
