package com.sky.coursework2base.exception;

public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException() {
        super("Отсутствует один из параметров");
    }
}
