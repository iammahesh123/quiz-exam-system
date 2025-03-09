package com.jntugv.exammanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String role;
}

