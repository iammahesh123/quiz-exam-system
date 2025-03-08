package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.model.QuestionRequestDTO;
import com.jntugv.exammanagement.model.QuestionResponseDTO;
import com.jntugv.exammanagement.service.QuestionService;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(value = "/add-question",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<QuestionResponseDTO> create(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return ResponseEntity.ok(questionService.createQuestion(questionRequestDTO));
    }

    @PutMapping(value = "/{question_id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<QuestionResponseDTO> update( @PathVariable("question_id") long id, @RequestBody QuestionRequestDTO questionRequestDTO) {
        return ResponseEntity.ok(questionService.updateQuestion(id, questionRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> findAll() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
