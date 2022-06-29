package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;

public interface ICustomerService {
     void createCustomer(Customer customer);

    Customer findByCustomerId(String customerId);

}
