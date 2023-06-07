package com.sky.coursework2base.controller;

import com.sky.coursework2base.model.Question;
import com.sky.coursework2base.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/exam/get/{amount}")

public class ExaminerController {
    private final ExaminerService examinerService;
    public ExaminerController(ExaminerService ExaminerServiceImpl) {
        this.examinerService = ExaminerServiceImpl;
    }
@GetMapping
    public Collection<Question> getExamQuestions( @PathVariable Integer amount) {
        return Collections.unmodifiableCollection(examinerService.getQuestions(amount));
    }
}
