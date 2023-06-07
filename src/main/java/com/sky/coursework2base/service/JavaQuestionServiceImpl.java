package com.sky.coursework2base.service;

import com.sky.coursework2base.exception.QuestionAlreadyExistException;
import com.sky.coursework2base.exception.QuestionNotFoundException;
import com.sky.coursework2base.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
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
    public Question remove(String question, String answer) {
        Question removingQuestion = new Question(question, answer);
        if(!(questions.remove(removingQuestion))) {
            throw new QuestionNotFoundException();
        }
        else {
            return removingQuestion;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion(Random random) {
        List<Question> questionsList = questions.stream().toList();
        int randomInt = random.nextInt(questionsList.size());
        return questionsList.get(randomInt);
    }
}
