package com.jntugv.exammanagement.mapper;

import com.jntugv.exammanagement.entity.Department;
import com.jntugv.exammanagement.model.DepartmentRequestDTO;
import com.jntugv.exammanagement.model.DepartmentResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    private final ModelMapper modelMapper;

    public DepartmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DepartmentResponseDTO toDTO(Department department) {
        DepartmentResponseDTO responseDTO = modelMapper.map(department, DepartmentResponseDTO.class);
        return responseDTO;
    }

    public Department toEntity(DepartmentRequestDTO departmentRequestDTO) {
        Department department = modelMapper.map(departmentRequestDTO, Department.class);
        return department;
    }
}
