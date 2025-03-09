package com.jntugv.exammanagement.model;

import com.jntugv.exammanagement.enums.UserRoles;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String department;
    private UserRoles role;
}
