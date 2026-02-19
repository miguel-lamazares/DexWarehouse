package com.DexWarehouse.controller;

import com.DexWarehouse.dto.LoginRequest;
import com.DexWarehouse.dto.LoginResponse;
import com.DexWarehouse.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest dto) {

        return ResponseEntity.ok(authService.login(dto));
    }
}
