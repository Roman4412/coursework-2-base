package com.sky.coursework2base.model;

import com.sky.coursework2base.exception.InvalidQuestionException;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        validateQuestion(question,answer);
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, question);
    }
    public static void validateQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new InvalidQuestionException();
        }
    }
}
