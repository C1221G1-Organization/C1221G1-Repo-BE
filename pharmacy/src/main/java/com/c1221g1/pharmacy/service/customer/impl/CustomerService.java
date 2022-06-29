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
    public Customer save(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findByCustomerId(String customerId) {
        return this.iCustomerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.iCustomerRepository.updateCustomer(customer.getCustomerName(), customer.getCustomerAddress()
                , customer.getCustomerBirthday(), customer.getCustomerGender(), customer.getCustomerNote(), customer.getCustomerPhone(),
                customer.getCustomerType().getCustomerTypeId(),customer.getCustomerId());
    }

}
