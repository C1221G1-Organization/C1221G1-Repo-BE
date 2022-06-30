package com.c1221g1.pharmacy.service.customer.impl;

import com.c1221g1.pharmacy.repository.customer.ICustomerTypeRepository;
import com.c1221g1.pharmacy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerType implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to get customer type in database
     */

    @Override
    public List<com.c1221g1.pharmacy.entity.customer.CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.getAllCustomerType();
    }
}
