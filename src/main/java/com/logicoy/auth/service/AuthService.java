package com.logicoy.auth.service;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.logicoy.auth.dto.LoginRequestDto;
import com.logicoy.auth.dto.LoginResponseDto;
import com.logicoy.auth.entity.User;
import com.logicoy.auth.security.JwtUtil;

/**
 * Service that handles authentication logic.
 */
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // Constructor injection
    public AuthService(AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Authenticates user credentials and returns JWT.
     */
    public LoginResponseDto login(LoginRequestDto request) {

        // Step 1: Authenticate username & password
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        // Step 2: Get authenticated user
        User user = (User) authentication.getPrincipal();

        // Step 3: Generate JWT
        String token = jwtUtil.generateToken(user.getUsername());

        // Step 4: Prepare response
        LoginResponseDto response = new LoginResponseDto();
        response.setId(user.getId());
        response.setJwt(token);

        return response;
    }
}
