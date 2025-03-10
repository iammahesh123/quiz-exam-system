package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.model.BranchRequestDTO;
import com.jntugv.exammanagement.model.BranchResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchService {
    BranchResponseDTO createBranch(BranchRequestDTO branchRequestDTO);
    BranchResponseDTO updateBranch(Long id,BranchRequestDTO branchRequestDTO);
    BranchResponseDTO getBranch(Long id);
    List<BranchResponseDTO> getAllBranches();
    HttpStatus deleteBranch(Long id);
}
