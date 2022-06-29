package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
