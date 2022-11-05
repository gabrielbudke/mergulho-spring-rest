package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Customer;

@RestController
public class CustomerController {
    
    @GetMapping("/customers")
    public List<Customer> listar() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("João");
        customer.setEmail("joao@algalog.com.br");
        customer.setTelefone("47 98787-6767");
        
        return Arrays.asList(customer);
    }

}
