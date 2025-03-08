package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.model.QuestionRequestDTO;
import com.jntugv.exammanagement.model.QuestionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface QuestionService {
    QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO);
    QuestionResponseDTO updateQuestion(Long id,QuestionRequestDTO questionRequestDTO);
    QuestionResponseDTO deleteQuestion(Long id);
    QuestionResponseDTO getQuestion(Long id);
    List<QuestionResponseDTO> getAllQuestions();
    //search api
    //filter
}
