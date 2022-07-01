package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

    /**
     * Create by TruongNQ
     * Time : 23:59 29/06/2022
     * Function this method to get customer type in database
     */
    @Query(value = "SELECT customer_type_id, customer_type_name FROM customer_type", nativeQuery = true)
    List<CustomerType> getAllCustomerType();

}
