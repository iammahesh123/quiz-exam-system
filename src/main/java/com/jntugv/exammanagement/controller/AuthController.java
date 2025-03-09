package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.entity.User;
import com.jntugv.exammanagement.model.AuthResponseDTO;
import com.jntugv.exammanagement.model.LoginDTO;
import com.jntugv.exammanagement.model.UserDTO;
import com.jntugv.exammanagement.repository.UserRepository;
import com.jntugv.exammanagement.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
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

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
        String token = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow();
        return new AuthResponseDTO(token, user.getRole().name());
    }

    @PutMapping("/update-profile")
    public String updateProfile(@RequestHeader("Authorization") String token, @RequestBody UserDTO userDTO) {
        String email = jwtUtil.extractUsername(token.substring(7));
        User user = userRepository.findByEmail(email).orElseThrow();

        user.setFullName(userDTO.getFullName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAddress(userDTO.getAddress());
        //user.setDepartment(userDTO.getDepartment());

        userRepository.save(user);
        return "Profile updated successfully!";
    }
}

