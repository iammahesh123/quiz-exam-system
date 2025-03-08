package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.model.ExamTestRequestDTO;
import com.jntugv.exammanagement.model.ExamTestResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamTestService {
    ExamTestResponseDTO createExamTest(ExamTestRequestDTO examTestRequestDTO);
    ExamTestResponseDTO updateExamTest(Long id,ExamTestRequestDTO examTestRequestDTO);
    ExamTestResponseDTO getExamTestById(Long id);
    List<ExamTestResponseDTO> getAllExamTests();
    ExamTestResponseDTO deleteExamTest(Long id);
}
