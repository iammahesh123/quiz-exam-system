package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.Branch;
import com.jntugv.exammanagement.entity.Department;
import com.jntugv.exammanagement.mapper.BranchMapper;
import com.jntugv.exammanagement.model.BranchRequestDTO;
import com.jntugv.exammanagement.model.BranchResponseDTO;
import com.jntugv.exammanagement.repository.BranchRepository;
import com.jntugv.exammanagement.repository.DepartmentRepository;
import com.jntugv.exammanagement.service.BranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;
    private final DepartmentRepository departmentRepository;

    public BranchServiceImpl(BranchRepository branchRepository, BranchMapper branchMapper, DepartmentRepository departmentRepository) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public BranchResponseDTO createBranch(BranchRequestDTO branchRequestDTO) {
        Branch branch = new Branch();
        BeanUtils.copyProperties(branchRequestDTO, branch);
        if(branchRequestDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(branchRequestDTO.getDepartmentId()).orElse(null);
            branch.setDepartment(department);
            //department.setBranches((List<Branch>) branch);
            departmentRepository.save(department);
        }
        Branch savedBranch = branchRepository.save(branch);
        return branchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchResponseDTO updateBranch(Long id, BranchRequestDTO branchRequestDTO) {
        Branch branch = branchRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(branchRequestDTO, branch);
        Branch savedBranch = branchRepository.save(branch);
        return branchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchResponseDTO getBranch(Long id) {
        Branch branch = branchRepository.findById(id).orElse(null);
        return branchMapper.toDTO(branch);
    }

    @Override
    public List<BranchResponseDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(branchMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HttpStatus deleteBranch(Long id) {
        Branch branch = branchRepository.findById(id).orElse(null);
        branchRepository.delete(branch);
        return HttpStatus.OK;
    }
}
