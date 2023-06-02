package com.sky.coursework2base.service;

import com.sky.coursework2base.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random;
    private final QuestionService questionService;
    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {

        return null;
    }
}
