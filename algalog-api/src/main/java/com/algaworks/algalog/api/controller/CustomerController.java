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

        var firstCustomer = new Customer();
        firstCustomer.setId(1L);
        firstCustomer.setName("João");
        firstCustomer.setEmail("joao@algalog.com.br");
        firstCustomer.setPhoneNumber("4798787-6767");

        var secondCustomer = new Customer();
        secondCustomer.setId(2L);
        secondCustomer.setName("Maria");
        secondCustomer.setEmail("maria@algalog.com.br");
        secondCustomer.setPhoneNumber("4798585-4545");  

        return Arrays.asList(firstCustomer, secondCustomer);

    }

}
