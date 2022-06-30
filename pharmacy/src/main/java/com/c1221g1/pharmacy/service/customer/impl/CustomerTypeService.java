package com.c1221g1.pharmacy.service.customer.impl;

import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.repository.customer.ICustomerTypeRepository;
import com.c1221g1.pharmacy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return this.iCustomerTypeRepository.findAllCustomerType();
    }

}