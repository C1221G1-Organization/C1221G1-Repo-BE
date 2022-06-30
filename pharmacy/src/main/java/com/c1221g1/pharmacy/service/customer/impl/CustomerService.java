package com.c1221g1.pharmacy.service.customer.impl;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to get and search customer in database
     */

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String customerId, String customerName, String customerAddress, String customerPhone, String customerType) {
        return iCustomerRepository.getAllSearchAndSortCustomer("%" + customerId + "%", "%" + customerType + "%", "%" + customerName + "%", "%" + customerAddress + "%", "%" + customerPhone + "%", pageable);
    }


    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to update flag table customer
     */

    @Override
    public void deleteCustomer(String id) {
        iCustomerRepository.deleteCustomer(id);
    }

    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to find id customer in database
     */

    @Override
    public Customer findById(String id) {
        return iCustomerRepository.findByCustomerId(id).orElse(null);
    }

}
