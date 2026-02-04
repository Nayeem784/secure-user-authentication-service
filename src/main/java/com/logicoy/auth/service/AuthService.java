package com.logicoy.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.logicoy.auth.dto.LoginRequestDto;
import com.logicoy.auth.dto.LoginResponseDto;
import com.logicoy.auth.entity.User;

/**
 * Handles authentication logic.
 */
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    // Constructor injection (mandatory)
    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticates user credentials.
     * JWT generation will be added next.
     */
    public LoginResponseDto login(LoginRequestDto loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );

        User user = (User) authentication.getPrincipal();

        // Temporary response (JWT will be added next)
        LoginResponseDto response = new LoginResponseDto();
        response.setId(user.getId());

        return response;
    }
}
