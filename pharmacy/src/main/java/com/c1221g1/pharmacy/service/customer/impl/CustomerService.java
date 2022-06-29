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

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getRetailCustomer
     * */
    @Override
    public Customer getRetailCustomer() {
        return this.iCustomerRepository.getRetailCustomer();
    }
}
