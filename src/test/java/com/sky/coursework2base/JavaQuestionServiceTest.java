package com.sky.coursework2base;

import com.sky.coursework2base.exception.QuestionAlreadyExistException;
import com.sky.coursework2base.exception.QuestionNotFoundException;
import com.sky.coursework2base.model.Question;
import com.sky.coursework2base.service.JavaQuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

public class JavaQuestionServiceTest {

    JavaQuestionServiceImpl out = new JavaQuestionServiceImpl();


    @Test
    public void addTest() {
        Question actual = out.add("some question", "some answer");
        Question expected = new Question("some question","some answer");
        assertEquals(out.getAll().size(),1);
        assertEquals(actual,expected);
    }
    @Test
    public void addExceptionTest() {
        out.add("some question", "some answer");
        Exception e = assertThrows(QuestionAlreadyExistException.class,() -> out.add("some question", "some answer"));
        assertEquals(e.getMessage(), "Такой вопрос уже существует");
    }

    @Test
    public void removeTest() {
        out.add("some question", "some answer");
        Question actual = out.remove("some question", "some answer");
        assertEquals(out.getAll().size(),0);
        assertEquals(actual,new Question("some question","some answer"));
    }

    @Test
    public void removeExceptionTest() {
        Exception e = assertThrows(QuestionNotFoundException.class,() -> out.remove("some question", "some answer"));
        assertEquals(e.getMessage(),"Вопрос не найден");
        assertEquals(out.getAll().size(),0);
    }

    @Test
    public void getAllTest() {
        out.add("question1", "answer1");
        out.add("question2", "answer2");
        out.add("question3", "answer3");
        Collection <Question> actual = out.getAll();
        assertIterableEquals(actual,out.getQuestions());
    }
}
