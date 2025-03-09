package com.jntugv.exammanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String email;
    private String password;
}
