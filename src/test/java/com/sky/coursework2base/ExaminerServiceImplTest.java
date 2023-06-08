package com.sky.coursework2base;

import com.sky.coursework2base.exception.InvalidAmountException;
import com.sky.coursework2base.model.Question;
import com.sky.coursework2base.service.ExaminerServiceImpl;
import com.sky.coursework2base.service.JavaQuestionServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    Collection <Question> testQuestionsStorage = Set.of(
            new Question("1","1"),
            new Question("2","2"),
            new Question("3","3")
    );
    @Mock
    JavaQuestionServiceImpl mock;
    @InjectMocks
    ExaminerServiceImpl out;
    @Test
    public void getQuestionsExceptionIfAmountNullTest() {
        Exception e = assertThrows(InvalidAmountException.class, () -> out.getQuestions(null));
        assertEquals(e.getMessage(),"Превышено количество");
    }
    @Test
    public void getQuestionsExceptionIfAmountLessThanZero() {
        Exception e = assertThrows(InvalidAmountException.class, () -> out.getQuestions(-1));
        assertEquals(e.getMessage(),"Превышено количество");
    }
    @Test
    public void getQuestionsExceptionIfAmountMoreThanAvailable() {
        Mockito.when(mock.getAll()).thenReturn(testQuestionsStorage);
        Exception e = assertThrows(InvalidAmountException.class, () -> out.getQuestions(6));
        assertEquals(e.getMessage(),"Превышено количество");
    }

    @Test
    public void getQuestionsTest() {
        Mockito.when(mock.getAll()).thenReturn(testQuestionsStorage);
        Mockito.when(mock.getRandomQuestion(out.getRandom()))
                .thenReturn(new Question("1","1"))
                .thenReturn(new Question("1","1"))
                .thenReturn(new Question("2","2"))
                .thenReturn(new Question("3","3"))
                .thenReturn(new Question("3","3"));

        Iterable<Question> actual =  out.getQuestions(3);
        assertThat(actual).containsOnlyOnceElementsOf(testQuestionsStorage);
        assertEquals(out.getExamQuestions().size(),3);
    }


}
