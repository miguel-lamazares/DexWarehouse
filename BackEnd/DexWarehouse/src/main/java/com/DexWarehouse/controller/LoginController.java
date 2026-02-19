package com.DexWarehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
}

// ✅ Rate limit

// ✅ Lock por tentativas

// ✅ 2FA

// ✅ HTTPS 

//🔐 Criar autenticação com hash + salt + pepper real
// 🔐 Bloquear brute force
// 🔐 Auditoria de acesso