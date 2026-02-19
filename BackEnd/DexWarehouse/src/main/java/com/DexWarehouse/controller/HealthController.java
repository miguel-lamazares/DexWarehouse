package com.DexWarehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/admin")
    public String health() {
        return "Nao tente hackear sistemas alheios, isso e um pouco chato, eu como sou uma pessoa muito boa so salvei seu ip, localizaco e algumas outras informacoes, sou bem priguisoso, talvez eu brinque com ussoi ou nao.";
    }
}
