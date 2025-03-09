package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.Questions;
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
        Questions questions = new Questions();
        BeanUtils.copyProperties(questionRequestDTO, questions);
        System.out.println(questions);
        questionRepository.save(questions);
        return questionMapper.toDTO(questions);

    }

    @Override
    public QuestionResponseDTO updateQuestion(Long id,QuestionRequestDTO questionRequestDTO) {
        Questions questions = questionRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(questionRequestDTO, questions);
        Questions savedQuestion = questionRepository.save(questions);
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public QuestionResponseDTO deleteQuestion(Long id) {
        Questions questions = questionRepository.findById(id).orElse(null);
        questionRepository.delete(questions);
        return questionMapper.toDTO(questions);
    }

    @Override
    public QuestionResponseDTO getQuestion(Long id) {
       Questions questions = questionRepository.findById(id).orElse(null);
       return questionMapper.toDTO(questions);
    }

    @Override
    public List<QuestionResponseDTO> getAllQuestions() {
        List<Questions> questions = questionRepository.findAll();
        return questions.stream().map(testQuestion -> questionMapper.toDTO(testQuestion)).collect(Collectors.toList());
    }
}
