package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.User;
import com.jntugv.exammanagement.model.DashboardResponseDTO;
import com.jntugv.exammanagement.repository.UserRepository;
import com.jntugv.exammanagement.service.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    private final UserRepository userRepository;

    public DashboardServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DashboardResponseDTO getDashboardData(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DashboardResponseDTO response = new DashboardResponseDTO();
        response.setUsername(user.getUsername());
        response.setRole(user.getRole().toString());

        switch (user.getRole()) {
            case ADMIN:
                response.setMessage("Welcome, Admin! You can manage exams, students, and teachers.");
                break;
            case TEACHER:
                response.setMessage("Welcome, Teacher! You can create quizzes and review results.");
                break;
            case STUDENT:
                response.setMessage("Welcome, Student! You can take quizzes and check your results.");
                break;
            default:
                response.setMessage("Invalid role.");
        }
        return response;
    }
    }

