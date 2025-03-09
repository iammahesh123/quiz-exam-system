package com.jntugv.exammanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTestRequestDTO {
    private String examName;
    private String examDescription;
    private String subjectName;
    private LocalDate examDate;
    private LocalDateTime examTime;
    private LocalDate dueDate;
    private String semister;
    private String branch;
    private String facultyName;
    private long totalQuestions;
    private List<Long> questionIds;
}
