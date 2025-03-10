package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.model.DepartmentRequestDTO;
import com.jntugv.exammanagement.model.DepartmentResponseDTO;
import com.jntugv.exammanagement.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }
}
