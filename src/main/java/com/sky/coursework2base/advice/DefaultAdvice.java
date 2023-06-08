package com.sky.coursework2base.advice;

import com.sky.coursework2base.exception.InvalidAmountException;
import com.sky.coursework2base.exception.InvalidQuestionException;
import com.sky.coursework2base.exception.QuestionAlreadyExistException;
import com.sky.coursework2base.exception.QuestionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(InvalidQuestionException.class)
    public String handleException() {
        return new InvalidQuestionException().getMessage();
    }
    @ExceptionHandler(QuestionAlreadyExistException.class)
    public String handleException1() {
        return new QuestionAlreadyExistException().getMessage();
    }
    @ExceptionHandler(QuestionNotFoundException.class)
    public String handleException2() {
        return new QuestionNotFoundException().getMessage();
    }
    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<?> handleException3(InvalidAmountException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
