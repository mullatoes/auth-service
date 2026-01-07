package com.kyeiiih.authservice.application.service;

import com.kyeiiih.authservice.api.dto.RegisterRequest;
import com.kyeiiih.authservice.api.dto.RegisterResponse;
import com.kyeiiih.authservice.domain.model.User;
import com.kyeiiih.authservice.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalStateException("Email already registered");
        }

        String hashedPassword = passwordEncoder.encode(request.password());

        User user = new User(
                UUID.randomUUID(),
                request.email(),
                hashedPassword
        );

        userRepository.save(user);

        return new RegisterResponse(user.getId(), user.getEmail());
    }
}
