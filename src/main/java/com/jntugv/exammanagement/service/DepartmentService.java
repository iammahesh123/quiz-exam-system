package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.entity.Department;
import com.jntugv.exammanagement.model.DepartmentRequestDTO;
import com.jntugv.exammanagement.model.DepartmentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);
    DepartmentResponseDTO updateDepartment(Long id,DepartmentRequestDTO departmentRequestDTO);
    DepartmentResponseDTO getDepartment(Long id);
    List<DepartmentResponseDTO> getAllDepartments();
    HttpStatus deleteDepartment(Long id);
}
