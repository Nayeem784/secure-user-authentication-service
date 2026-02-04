package com.logicoy.auth.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request body for login.
 */
public class LoginRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}
