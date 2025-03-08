package com.jntugv.exammanagement.repository;

import com.jntugv.exammanagement.entity.TestQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<TestQuestions, Long> {
}
