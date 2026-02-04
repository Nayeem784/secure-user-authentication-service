package com.logicoy.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logicoy.auth.dto.LoginRequestDto;
import com.logicoy.auth.dto.LoginResponseDto;
import com.logicoy.auth.service.AuthService;

import jakarta.validation.Valid;

/**
 * Authentication endpoints.
 */
@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    private final AuthService authService;

    // Constructor injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto loginRequest) {

        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
