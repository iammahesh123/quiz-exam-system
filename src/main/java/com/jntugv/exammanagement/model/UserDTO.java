package com.jntugv.exammanagement.model;

import com.jntugv.exammanagement.enums.UserRoles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRoles role;
    private Long departmentId;
    private Long branchId;
}
