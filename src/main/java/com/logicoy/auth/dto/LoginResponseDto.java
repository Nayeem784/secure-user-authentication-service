package com.logicoy.auth.dto;

/**
 * Login response payload.
 */
public class LoginResponseDto {

    private String jwt;
    private Long id;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
