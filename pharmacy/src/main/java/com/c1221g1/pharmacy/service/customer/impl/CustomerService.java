package com.c1221g1.pharmacy.service.customer.impl;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public void createCustomer(Customer customer) {
        this.iCustomerRepository.saveCustomer(customer.getCustomerName(), customer.getCustomerBirthday(),
                customer.getCustomerGender(), customer.getCustomerAddress(), customer.getCustomerPhone(), customer.getCustomerNote());
    }

    @Override
    public Customer findByCustomerId(String customerId) {
        return this.iCustomerRepository.findById(customerId).orElse(null);
    }

}
