package com.logicoy.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logicoy.auth.entity.User;

/**
 * Repository interface for User entity.
 * 
 * Provides database access methods for authentication
 * and user management.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Fetch user by username.
     * 
     * Spring Security uses this method during authentication.
     */
    Optional<User> findByUsername(String username);
}
