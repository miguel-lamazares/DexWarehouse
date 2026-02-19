package com.DexWarehouse.config;

import com.DexWarehouse.model.User;
import com.DexWarehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Value("${app.security.pepper}")
    private String pepper;

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, PasswordEncoder encoder) {
        return args -> {
            if (repository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                // A senha será Admin@123 + o pepper 'CrenildaTROP'
                admin.setPasswordHash(encoder.encode("Admin@123" + pepper));
                repository.save(admin);
                System.out.println("🚀 [SISTEMA] Usuário ADM criado: login 'admin' / senha 'Admin@123'");
            }
        };
    }
}