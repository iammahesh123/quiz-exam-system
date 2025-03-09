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
import java.util.stream.Collectors;

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
        ExamTest examTest = examTestRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(examTestRequestDTO, examTest);
        ExamTest savedTest = examTestRepository.save(examTest);
        return examTestMapper.toDO(savedTest);
    }

    @Override
    public ExamTestResponseDTO getExamTestById(Long id) {
        ExamTest examTest = examTestRepository.findById(id).orElse(null);
        return examTestMapper.toDO(examTest);
    }

    @Override
    public List<ExamTestResponseDTO> getAllExamTests() {
        List<ExamTest> examTests = examTestRepository.findAll();
        return examTests.stream().map(test -> examTestMapper.toDO(test)).collect(Collectors.toList());
    }

    @Override
    public ExamTestResponseDTO deleteExamTest(Long id) {
        ExamTest examTest = examTestRepository.findById(id).orElse(null);
        examTestRepository.delete(examTest);
        return examTestMapper.toDO(examTest);
    }
}
