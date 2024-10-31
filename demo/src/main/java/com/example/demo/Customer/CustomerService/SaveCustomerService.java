package com.example.demo.Customer.CustomerService;

import com.example.demo.Customer.CustomerEntity.CustomerAccountEntity;
import com.example.demo.Customer.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerAccountEntity saveCustomerService(CustomerAccountEntity customerAccount)
    {
       return customerRepository.save(customerAccount);
    }
}