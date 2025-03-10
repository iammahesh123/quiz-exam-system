package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.Branch;
import com.jntugv.exammanagement.model.BranchResponseDTO;
import com.jntugv.exammanagement.model.DepartmentResponseDTO;
import com.jntugv.exammanagement.model.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class BranchMapper {
    private final ModelMapper modelMapper;

    public BranchMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BranchResponseDTO toDTO(Branch branch) {
        BranchResponseDTO responseDTO =  modelMapper.map(branch, BranchResponseDTO.class);
        if (branch.getDepartment() != null) {
            responseDTO.setDepartmentResponseDTO(modelMapper.map(branch.getDepartment(), DepartmentResponseDTO.class));

        }
        if (branch.getUser() != null) {
            responseDTO.setUserResponseDTOS(Collections.singletonList(modelMapper.map(branch.getUser(), UserResponseDTO.class)));
        }
        return responseDTO;
    }
}
