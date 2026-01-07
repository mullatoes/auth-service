package com.kyeiiih.authservice.api.dto;

public record RegisterRequest(
        String email,
        String password
) {
}
