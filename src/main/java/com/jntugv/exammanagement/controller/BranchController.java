package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.model.BranchRequestDTO;
import com.jntugv.exammanagement.model.BranchResponseDTO;
import com.jntugv.exammanagement.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<BranchResponseDTO> createBranch(@RequestBody BranchRequestDTO branchRequestDTO) {
        return ResponseEntity.ok(branchService.createBranch(branchRequestDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponseDTO> updateBranch(@PathVariable("id") Long id, @RequestBody BranchRequestDTO branchRequestDTO) {
        return ResponseEntity.ok(branchService.updateBranch(id, branchRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDTO> getBranch(@PathVariable("id") Long id) {
        return ResponseEntity.ok(branchService.getBranch(id));
    }

    @GetMapping
    public ResponseEntity<List<BranchResponseDTO>> getAllBranch() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBranch(@PathVariable("id") Long id) {
        return ResponseEntity.ok(branchService.deleteBranch(id));
    }
}
