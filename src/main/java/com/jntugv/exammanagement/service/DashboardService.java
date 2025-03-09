package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.model.DashboardResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface DashboardService {
    DashboardResponseDTO getDashboardData(String username);
}
