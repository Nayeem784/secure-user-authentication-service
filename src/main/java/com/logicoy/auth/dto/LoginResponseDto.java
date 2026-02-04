package com.logicoy.auth.dto;

/**
 * DTO sent back to client after successful login.
 * Contains JWT token and user identifier.
 */
public class LoginResponseDto {

    private Long id;
    private String jwt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
