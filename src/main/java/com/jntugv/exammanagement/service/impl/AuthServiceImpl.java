package com.jntugv.exammanagement.service.impl;

import com.jntugv.exammanagement.entity.Branch;
import com.jntugv.exammanagement.entity.Department;
import com.jntugv.exammanagement.entity.User;
import com.jntugv.exammanagement.mapper.UserMapper;
import com.jntugv.exammanagement.model.AuthResponseDTO;
import com.jntugv.exammanagement.model.LoginDTO;
import com.jntugv.exammanagement.model.UserDTO;
import com.jntugv.exammanagement.model.UserResponseDTO;
import com.jntugv.exammanagement.repository.BranchRepository;
import com.jntugv.exammanagement.repository.DepartmentRepository;
import com.jntugv.exammanagement.repository.UserRepository;
import com.jntugv.exammanagement.security.JwtUtil;
import com.jntugv.exammanagement.service.AuthService;
import com.jntugv.exammanagement.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final BranchRepository branchRepository;
    private final DepartmentRepository departmentRepository;
    private final UserMapper userMapper;
    private final EmailService emailService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService, BranchRepository branchRepository, DepartmentRepository departmentRepository, UserMapper userMapper, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.branchRepository = branchRepository;
        this.departmentRepository = departmentRepository;
        this.userMapper = userMapper;
        this.emailService = emailService;
    }

    @Override
    public String register(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
        String token = jwtUtil.generateToken(userDetails);
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow();
        return new AuthResponseDTO(token, user.getRole().name());
    }

    @Override
    public UserResponseDTO updateProfile(String token, UserDTO userDTO) {
        String email = jwtUtil.extractUsername(token.substring(7));
        User user = userRepository.findByEmail(email).orElseThrow();
        BeanUtils.copyProperties(userDTO, user);
        if(userDTO.getBranchId() != null) {
            Branch branch = branchRepository.findById(userDTO.getBranchId()).orElseThrow();
            user.setBranch(branch);
            branchRepository.save(branch);
        }

        if (userDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(userDTO.getDepartmentId()).orElseThrow();
            user.setDepartment(department);
            departmentRepository.save(department);
        }

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public String sendPasswordResetToken(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
        String token = jwtUtil.generatePasswordResetToken(email);
        String resetLink = "http://localhost:8080/auth/reset-password?token=" + token;
        String emailBody = "<p>Hello,</p>"
                + "<p>You requested a password reset. Click the link below to reset your password:</p>"
                + "<p><a href=\"" + resetLink + "\">Reset Password</a></p>"
                + "<p>If you didn't request this, ignore this email.</p>";
        emailService.sendEmail(email, "Password Reset Request", emailBody);
        return "Password reset link sent to your email.";
    }

    public String resetPassword(String token, String newPassword) {
        String email = jwtUtil.extractEmailFromResetToken(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!jwtUtil.validateResetToken(token, email)) {
            throw new IllegalArgumentException("Invalid or expired token");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return "Password has been successfully reset.";
    }
}
