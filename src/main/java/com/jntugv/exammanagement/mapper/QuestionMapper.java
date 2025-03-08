package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.TestQuestions;
import com.jntugv.exammanagement.model.QuestionResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    ModelMapper modelMapper = new ModelMapper();
    public QuestionResponseDTO toDTO(TestQuestions questionRequestDTO) {
        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
    }
}
