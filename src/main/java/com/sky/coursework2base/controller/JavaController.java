package com.sky.coursework2base.controller;

import com.sky.coursework2base.model.Question;
import com.sky.coursework2base.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService questionService;

    @Autowired
    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    Question addQuestion(@RequestParam(required = false) String question,
                         @RequestParam(required = false) String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    Question removeQuestion(@RequestParam(required = false) String question,
                            @RequestParam(required = false) String answer) {
        return questionService.remove(question,answer);
    }
    @GetMapping
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

}
