package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;

public interface ICustomerService {
    Customer findByCustomerId(String customerId);
}
