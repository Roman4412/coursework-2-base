package com.sky.coursework2base.service;

import com.sky.coursework2base.exception.QuestionAlreadyExistException;
import com.sky.coursework2base.exception.QuestionNotFoundException;
import com.sky.coursework2base.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.sky.coursework2base.model.Question.validateQuestion;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionServiceImpl(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        validateQuestion(question,answer);
        Question newQuestion = new Question(question,answer);
        if (questions.add(newQuestion)) {
            return newQuestion;
        } else {
            throw new QuestionAlreadyExistException();
        }
    }

    @Override
    public Question add(Question question) {
        if (!(questions.add(question))) {
            throw new QuestionAlreadyExistException();
        } else {
            return question;
        }
    }

    @Override
    public Question remove(Question question) {
        Question removedQuestion = question;
        if(!(questions.remove(question))) {
            throw new QuestionNotFoundException();
        }
        else {
            return removedQuestion;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Question randomQuestion = null;
        Random random = new Random();
        int randomInt = random.nextInt(questions.size()+1);
        for (int i = 1; i != randomInt; i++) {
            randomQuestion = questions.iterator().next();
        }
        return randomQuestion;
    }

}
