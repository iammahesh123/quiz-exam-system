package com.jntugv.exammanagement.repository;

import com.jntugv.exammanagement.entity.ExamTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTestRepository extends JpaRepository<ExamTest, Long> {
}
