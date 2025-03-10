package com.jntugv.exammanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequestDTO {
    private String branchName;
    private String branchDescription;
    private String branchCode;
    private Long departmentId;
}
