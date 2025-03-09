package com.jntugv.exammanagement.model;

import com.jntugv.exammanagement.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private UserRoles role;
    private Long departmentId;
    private Long branchId;
}
