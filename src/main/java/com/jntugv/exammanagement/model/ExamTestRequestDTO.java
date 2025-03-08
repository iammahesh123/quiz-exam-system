package com.jntugv.exammanagement.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
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

    public ExamTestRequestDTO() {
    }

    public ExamTestRequestDTO(String examName, String examDescription, String subjectName, LocalDate examDate, LocalDateTime examTime, LocalDate dueDate, String semister, String branch, String facultyName) {
        this.examName = examName;
        this.examDescription = examDescription;
        this.subjectName = subjectName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.dueDate = dueDate;
        this.semister = semister;
        this.branch = branch;
        this.facultyName = facultyName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalDateTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalDateTime examTime) {
        this.examTime = examTime;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getSemister() {
        return semister;
    }

    public void setSemister(String semister) {
        this.semister = semister;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public long getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(long totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }
}
