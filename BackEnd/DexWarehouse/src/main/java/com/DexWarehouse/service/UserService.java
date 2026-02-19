package com.DexWarehouse.service;

import com.DexWarehouse.model.User;
import com.DexWarehouse.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final String pepper = System.getenv("PASSWORD_PEPPER");
    

    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User createUser(String username, String rawPassword) {
        String passwordWithPepper = rawPassword + pepper;  // pepper é a variável de ambiente
        User u = new User();
        u.setUsername(username);
        u.setPasswordHash(encoder.encode(passwordWithPepper));
        return repo.save(u);
    }
}
