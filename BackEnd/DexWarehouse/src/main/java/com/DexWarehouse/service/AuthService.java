package com.DexWarehouse.service;

import com.DexWarehouse.dto.LoginRequest;
import com.DexWarehouse.dto.LoginResponse;
import com.DexWarehouse.model.User;
import com.DexWarehouse.repository.UserRepository;
import com.DexWarehouse.security.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    @Value("${app.security.pepper}")
    String pepper;

    public AuthService(
        UserRepository repo,
        PasswordEncoder encoder,
        JwtService jwtService
    ) {
        this.userRepository = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }
    
    public LoginResponse login(LoginRequest dto) {
        

        User user = userRepository.findByUsername(dto.username())
            .orElseThrow(() -> new RuntimeException("Usuário inválido"));

        if (!encoder.matches(dto.password() + pepper, user.getPasswordHash())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(token);
    }
}
