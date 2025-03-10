package com.jntugv.exammanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchResponseDTO {
    private Long id;
    private String branchDescription;
    private String branchCode;
    private DepartmentResponseDTO departmentResponseDTO;
    private List<UserResponseDTO> userResponseDTOS;
}
