package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.ExamTest;
import com.jntugv.exammanagement.entity.TestQuestions;
import com.jntugv.exammanagement.mapper.ExamTestMapper;
import com.jntugv.exammanagement.model.ExamTestRequestDTO;
import com.jntugv.exammanagement.model.ExamTestResponseDTO;
import com.jntugv.exammanagement.repository.ExamTestRepository;
import com.jntugv.exammanagement.repository.QuestionRepository;
import com.jntugv.exammanagement.service.ExamTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTestServiceImpl implements ExamTestService {
    private final ExamTestRepository examTestRepository;
    private final ExamTestMapper examTestMapper;
    private final QuestionRepository questionRepository;

    public ExamTestServiceImpl(ExamTestRepository examTestRepository, ExamTestMapper examTestMapper, QuestionRepository questionRepository) {
        this.examTestRepository = examTestRepository;
        this.examTestMapper = examTestMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public ExamTestResponseDTO createExamTest(ExamTestRequestDTO examTestRequestDTO) {
        ExamTest examTest = new ExamTest();
        BeanUtils.copyProperties(examTestRequestDTO, examTest);
        if(examTestRequestDTO.getQuestionIds() != null) {
            List<TestQuestions> questions = questionRepository.findAllById(examTestRequestDTO.getQuestionIds());
            examTest.setQuestions(questions);
            questionRepository.saveAll(questions);
        }
        ExamTest savedTest = examTestRepository.save(examTest);
        return examTestMapper.toDO(savedTest);
    }

    @Override
    public ExamTestResponseDTO updateExamTest(Long id, ExamTestRequestDTO examTestRequestDTO) {
        return null;
    }

    @Override
    public ExamTestResponseDTO getExamTestById(Long id) {
        return null;
    }

    @Override
    public List<ExamTestResponseDTO> getAllExamTests() {
        return List.of();
    }

    @Override
    public ExamTestResponseDTO deleteExamTest(Long id) {
        return null;
    }
}
