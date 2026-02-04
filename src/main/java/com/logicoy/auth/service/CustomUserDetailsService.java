package com.logicoy.auth.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.logicoy.auth.repository.UserRepository;

/**
 * Loads user from DB for authentication & JWT validation.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
    }
}
