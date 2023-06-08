package com.sky.coursework2base.service;

import com.sky.coursework2base.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(Integer amount);
}
