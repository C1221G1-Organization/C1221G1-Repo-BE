package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
