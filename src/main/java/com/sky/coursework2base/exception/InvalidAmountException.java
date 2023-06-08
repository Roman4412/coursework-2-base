package com.sky.coursework2base.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Превышено количество");
    }
}
