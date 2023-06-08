package com.sky.coursework2base.service;

import com.sky.coursework2base.exception.InvalidAmountException;
import com.sky.coursework2base.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random;
    private final QuestionService questionService;
    private final Set<Question> examQuestions;

    @Autowired
    public ExaminerServiceImpl(QuestionService JavaQuestionServiceImpl) {
        this.questionService = JavaQuestionServiceImpl;
        this.random = new Random(questionService.getAll().size());
        this.examQuestions = new HashSet<>();
    }

    @Override
    public Collection<Question> getQuestions(Integer amount) {

        if (amount == null || amount > questionService.getAll().size() || amount < 0) {
            throw new InvalidAmountException();
        }
        if (examQuestions.size() > 0) {
            examQuestions.removeAll(questionService.getAll());
        }
        for (int i = 0; i < amount; i++) {
            if (!(examQuestions.add(questionService.getRandomQuestion(random)))) {
                i--;
            }
        }
        return Collections.unmodifiableCollection(examQuestions);
    }

    public Random getRandom() {
        return this.random;
    }

    public Set<Question> getExamQuestions() {
        return this.examQuestions;
    }
}
