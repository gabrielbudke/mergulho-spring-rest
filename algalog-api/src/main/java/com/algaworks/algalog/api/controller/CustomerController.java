package com.algaworks.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    
    @GetMapping
    public List<Customer> readCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> readCustomerById(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
            .map(customer -> ResponseEntity.ok(customer))
            .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        if(!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(customerId);
        customer = customerRepository.save(customer);

        return ResponseEntity.ok(customer);

    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        if(!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        customerRepository.deleteById(customerId);

        return ResponseEntity.noContent().build();
    }

}
