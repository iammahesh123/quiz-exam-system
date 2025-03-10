package com.jntugv.exammanagement.controller;

import com.jntugv.exammanagement.model.AuthResponseDTO;
import com.jntugv.exammanagement.model.LoginDTO;
import com.jntugv.exammanagement.model.UserDTO;
import com.jntugv.exammanagement.model.UserResponseDTO;
import com.jntugv.exammanagement.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Rest Services", description = "List of Auth Rest Services")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authService.register(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PutMapping("/update-profile")
    public ResponseEntity<UserResponseDTO> updateProfile(@RequestHeader("Authorization") String token, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authService.updateProfile(token, userDTO));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return ResponseEntity.ok(authService.sendPasswordResetToken(email));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        return ResponseEntity.ok(authService.resetPassword(token, newPassword));
    }

    @GetMapping("/get-profile")
    public ResponseEntity<UserResponseDTO> getProfile(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authService.getProfile(token));
    }
}

