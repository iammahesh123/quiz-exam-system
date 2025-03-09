package com.jntugv.exammanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "examTest",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TestQuestions> questions = new ArrayList<>();
}
