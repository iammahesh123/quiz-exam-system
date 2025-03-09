package com.jntugv.exammanagement.entity;

import com.jntugv.exammanagement.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionNumber;
    private String questionName;
    private String questionAnswer;
    private String branch;
    private long year;
    private long questionmarks;
    private String semister;

    @ElementCollection
    private List<String> options;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ManyToOne
    @JoinColumn(name = "exam_test_id")
    private QuizTest quizTest;

    @PostPersist
    public void generateSupplierNumber() {
        if (this.questionNumber == null) {
            this.questionNumber = String.format("QUES%05d", this.id);
        }
    }
}

