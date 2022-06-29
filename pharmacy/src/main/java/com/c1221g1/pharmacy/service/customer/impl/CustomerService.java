package com.c1221g1.pharmacy.service.customer.impl;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String customerId, String customerName, String customerAddress, String customerPhone, String customerType) {
        return iCustomerRepository.getAllSearchAndSortCustomer("%" + customerId + "%", "%" + customerType + "%", "%" + customerName + "%", "%" + customerAddress + "%", "%" + customerPhone + "%", pageable);
    }

//    @Override
//    public void deleteCustomer(String id) {
//        iCustomerRepository.deleteCustomer(id);
//    }
}
