package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable,
                                   String customerId,
                                   String customerName,
                                   String customerAddress,
                                   String customerPhone,
                                   String customerType);

    void deleteCustomer(String id);

    Customer findById(String id);

}
