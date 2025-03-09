package com.jntugv.exammanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String contact;
    private String hodName;
    private UserResponseDTO user;
}
