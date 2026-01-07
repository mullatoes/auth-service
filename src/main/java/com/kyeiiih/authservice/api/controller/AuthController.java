package com.kyeiiih.authservice.api.controller;

import com.kyeiiih.authservice.api.dto.RegisterRequest;
import com.kyeiiih.authservice.api.dto.RegisterResponse;
import com.kyeiiih.authservice.application.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRegistrationService registrationService;

    public AuthController(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return registrationService.register(request);
    }
}
