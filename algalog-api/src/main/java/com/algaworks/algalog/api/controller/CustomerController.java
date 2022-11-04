package com.algaworks.algalog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @GetMapping("/customers")
    public String listar() {
        return "Hello AlgaWorks";
    }

}
