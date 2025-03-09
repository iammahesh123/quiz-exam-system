package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.Questions;
import com.jntugv.exammanagement.model.QuestionResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    private final ModelMapper modelMapper;

    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionResponseDTO toDTO(Questions questionRequestDTO) {
        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
    }
}
