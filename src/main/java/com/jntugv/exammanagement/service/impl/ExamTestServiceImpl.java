package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.Questions;
import com.jntugv.exammanagement.entity.QuizTest;
import com.jntugv.exammanagement.mapper.ExamTestMapper;
import com.jntugv.exammanagement.model.ExamTestRequestDTO;
import com.jntugv.exammanagement.model.ExamTestResponseDTO;
import com.jntugv.exammanagement.repository.QuestionRepository;
import com.jntugv.exammanagement.repository.QuizTestRepository;
import com.jntugv.exammanagement.service.ExamTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamTestServiceImpl implements ExamTestService {
    private final QuizTestRepository quizTestRepository;
    private final ExamTestMapper examTestMapper;
    private final QuestionRepository questionRepository;

    public ExamTestServiceImpl(QuizTestRepository quizTestRepository, ExamTestMapper examTestMapper, QuestionRepository questionRepository) {
        this.quizTestRepository = quizTestRepository;
        this.examTestMapper = examTestMapper;
        this.questionRepository = questionRepository;
    }

    @Override
    public ExamTestResponseDTO createExamTest(ExamTestRequestDTO examTestRequestDTO) {
        QuizTest quizTest = new QuizTest();
        BeanUtils.copyProperties(examTestRequestDTO, quizTest);
        if(examTestRequestDTO.getQuestionIds() != null) {
            List<Questions> questions = questionRepository.findAllById(examTestRequestDTO.getQuestionIds());
            quizTest.setQuestions(questions);
            questionRepository.saveAll(questions);
        }
        QuizTest savedTest = quizTestRepository.save(quizTest);
        return examTestMapper.toDO(savedTest);
    }

    @Override
    public ExamTestResponseDTO updateExamTest(Long id, ExamTestRequestDTO examTestRequestDTO) {
        QuizTest quizTest = quizTestRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(examTestRequestDTO, quizTest);
        QuizTest savedTest = quizTestRepository.save(quizTest);
        return examTestMapper.toDO(savedTest);
    }

    @Override
    public ExamTestResponseDTO getExamTestById(Long id) {
        QuizTest quizTest = quizTestRepository.findById(id).orElse(null);
        return examTestMapper.toDO(quizTest);
    }

    @Override
    public List<ExamTestResponseDTO> getAllExamTests() {
        List<QuizTest> quizTests = quizTestRepository.findAll();
        return quizTests.stream().map(examTestMapper::toDO).collect(Collectors.toList());
    }

    @Override
    public HttpStatus deleteExamTest(Long id) {
        QuizTest quizTest = quizTestRepository.findById(id).orElse(null);
        quizTestRepository.delete(quizTest);
        return HttpStatus.OK;
    }
}
