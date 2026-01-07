package com.kyeiiih.authservice.api.dto;

import java.util.UUID;

public record RegisterResponse(
        UUID userId,
        String email
) {
}
