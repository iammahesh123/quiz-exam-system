package com.jntugv.exammanagement.repository;

import com.jntugv.exammanagement.entity.QuizTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizTestRepository extends JpaRepository<QuizTest, Long> {
}
