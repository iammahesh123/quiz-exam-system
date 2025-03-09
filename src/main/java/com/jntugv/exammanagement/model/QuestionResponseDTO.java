package com.jntugv.exammanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private String questionNumber;
    private String questionName;
    private String questionAnswer;
    private String branch;
    private long year;
    private long questionmarks;
    private String semister;
}
