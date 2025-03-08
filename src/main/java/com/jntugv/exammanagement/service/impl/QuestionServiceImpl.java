package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.TestQuestions;
import com.jntugv.exammanagement.mapper.QuestionMapper;
import com.jntugv.exammanagement.model.QuestionRequestDTO;
import com.jntugv.exammanagement.model.QuestionResponseDTO;
import com.jntugv.exammanagement.repository.QuestionRepository;
import com.jntugv.exammanagement.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;


    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;


    }

    @Override
    public QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO) {
        TestQuestions testQuestions = new TestQuestions();
        BeanUtils.copyProperties(questionRequestDTO, testQuestions);
        System.out.println(testQuestions);
        questionRepository.save(testQuestions);
        return questionMapper.toDTO(testQuestions);

    }

    @Override
    public QuestionResponseDTO updateQuestion(Long id,QuestionRequestDTO questionRequestDTO) {
        TestQuestions testQuestions = questionRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(questionRequestDTO, testQuestions);
        TestQuestions savedQuestion = questionRepository.save(testQuestions);
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO deleteQuestion(Long id) {
        TestQuestions testQuestions = questionRepository.findById(id).orElse(null);
        questionRepository.delete(testQuestions);
        return questionMapper.toDTO(testQuestions);
    }

    @Override
    public QuestionResponseDTO getQuestion(Long id) {
       TestQuestions testQuestions = questionRepository.findById(id).orElse(null);
       return questionMapper.toDTO(testQuestions);
    }

    @Override
    public List<QuestionResponseDTO> getAllQuestions() {
        List<TestQuestions> testQuestions = questionRepository.findAll();
        return testQuestions.stream().map(testQuestion -> questionMapper.toDTO(testQuestion)).collect(Collectors.toList());
    }
}
