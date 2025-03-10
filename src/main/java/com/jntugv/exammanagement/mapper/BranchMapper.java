package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.Branch;
import com.jntugv.exammanagement.model.BranchResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {
    private final ModelMapper modelMapper;

    public BranchMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BranchResponseDTO toDTO(Branch branch) {
        return modelMapper.map(branch, BranchResponseDTO.class);
    }
}
