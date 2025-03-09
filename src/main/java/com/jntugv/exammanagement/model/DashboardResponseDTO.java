package com.jntugv.exammanagement.model;

import lombok.Data;

@Data
public class DashboardResponseDTO {
    private String username;
    private String role;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DashboardResponseDTO() {
    }

    public DashboardResponseDTO(String username, String role, String message) {
        this.username = username;
        this.role = role;
        this.message = message;
    }
}
