package com.logicoy.auth.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

/**
 * User entity represents an authenticated application user.
 * 
 * This class:
 * 1. Is a JPA entity mapped to the "users" table
 * 2. Implements Spring Security's UserDetails interface
 *    so that Spring Security can use it for authentication
 */
@Entity
@Table(name = "users") // Avoid using reserved keyword "user" in MySQL
public class User implements UserDetails {

    /**
     * Primary key for the user table.
     * Auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username used for login.
     * Must be unique and not null.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * Encoded password.
     * PasswordEncoder will be used before saving.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Default constructor required by JPA.
     */
    public User() {
    }

    /**
     * Parameterized constructor for creating user objects.
     */
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the database ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the username for authentication.
     * Spring Security calls this during login.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the encoded password.
     * Spring Security uses this to validate credentials.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the authorities (roles/permissions) granted to the user.
     * 
     * Currently empty because roles are not implemented yet.
     * Will be extended later with ROLE_USER / ROLE_ADMIN.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * Indicates whether the account is expired.
     * Returning true means the account is valid.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the account is locked.
     * Returning true means the account is not locked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the credentials are expired.
     * Returning true means credentials are valid.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled.
     * Returning true allows authentication.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
