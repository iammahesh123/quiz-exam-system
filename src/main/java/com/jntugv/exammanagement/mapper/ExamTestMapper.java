package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.ExamTest;
import com.jntugv.exammanagement.model.ExamTestResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExamTestMapper {
    private final ModelMapper modelMapper;

    public ExamTestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ExamTestResponseDTO toDO(ExamTest test) {
        return modelMapper.map(test, ExamTestResponseDTO.class);
    }
}
