package com.sky.coursework2base.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("Вопрос не найден");
    }
}
