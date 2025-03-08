package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.model.ExamTestRequestDTO;
import com.jntugv.exammanagement.model.ExamTestResponseDTO;
import com.jntugv.exammanagement.service.ExamTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-tests")
public class ExamTestController {

    private final ExamTestService examTestService;

    public ExamTestController(ExamTestService examTestService) {
        this.examTestService = examTestService;
    }

    @PostMapping
    public ResponseEntity<ExamTestResponseDTO> createExamTest(@RequestBody ExamTestRequestDTO examTestRequestDTO) {
        ExamTestResponseDTO examTestResponseDTO = examTestService.createExamTest(examTestRequestDTO);
        return ResponseEntity.ok(examTestResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamTestResponseDTO> updateExamTest(@PathVariable("id") Long id, @RequestBody ExamTestRequestDTO examTestRequestDTO) {
        ExamTestResponseDTO examTestResponseDTO = examTestService.updateExamTest(id, examTestRequestDTO);
        return ResponseEntity.ok(examTestResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamTestResponseDTO> getExamTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok( examTestService.getExamTestById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExamTestResponseDTO>> getAllExamTests() {
        return ResponseEntity.ok(examTestService.getAllExamTests());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExamTestResponseDTO> deleteExamTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(examTestService.deleteExamTest(id));
    }
}
