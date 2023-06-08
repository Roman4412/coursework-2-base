package com.sky.coursework2base.exception;

public class QuestionAlreadyExistException extends RuntimeException {
    public QuestionAlreadyExistException() {
        super("Такой вопрос уже существует");
    }
}
