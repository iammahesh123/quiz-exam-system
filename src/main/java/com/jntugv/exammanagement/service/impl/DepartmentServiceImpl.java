package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.Department;
import com.jntugv.exammanagement.mapper.DepartmentMapper;
import com.jntugv.exammanagement.model.DepartmentRequestDTO;
import com.jntugv.exammanagement.model.DepartmentResponseDTO;
import com.jntugv.exammanagement.repository.DepartmentRepository;
import com.jntugv.exammanagement.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDTO, department);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentResponseDTO departmentResponseDTO = departmentMapper.toDTO(savedDepartment);
        return departmentResponseDTO;
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO departmentRequestDTO) {
        Department department = departmentRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(departmentRequestDTO, department);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentResponseDTO departmentResponseDTO = departmentMapper.toDTO(savedDepartment);
        return departmentResponseDTO;
    }

    @Override
    public DepartmentResponseDTO getDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        DepartmentResponseDTO departmentResponseDTO = departmentMapper.toDTO(department);
        return departmentResponseDTO;
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(departmentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HttpStatus deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        departmentRepository.delete(department);
        return HttpStatus.OK;
    }
}
