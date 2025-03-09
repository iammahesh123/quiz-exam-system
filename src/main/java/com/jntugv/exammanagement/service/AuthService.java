package com.jntugv.exammanagement.service;

import com.jntugv.exammanagement.model.AuthResponseDTO;
import com.jntugv.exammanagement.model.LoginDTO;
import com.jntugv.exammanagement.model.UserDTO;
import com.jntugv.exammanagement.model.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String register(UserDTO userDTO);
    AuthResponseDTO login(LoginDTO loginDTO);
    UserResponseDTO updateProfile(String token, UserDTO userDTO);
    String sendPasswordResetToken(String email);
    String resetPassword(String token, String newPassword);
}
