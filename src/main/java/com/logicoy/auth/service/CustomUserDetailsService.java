package com.logicoy.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logicoy.auth.entity.User;
import com.logicoy.auth.repository.UserRepository;

/**
 * Custom implementation of UserDetailsService.
 *
 * This class tells Spring Security how to load user
 * information from the database during authentication.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructor-based dependency injection.
     * Spring injects UserRepository automatically.
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads the user from the database using username.
     * This method is called by Spring Security during login
     * and JWT validation.
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found with username: " + username));
    }
}
