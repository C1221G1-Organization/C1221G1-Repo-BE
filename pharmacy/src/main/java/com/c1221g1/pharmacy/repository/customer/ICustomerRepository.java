package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getRetailCustomer
     * */
    @Query(value ="select * from customer order by customer_id asc limit 1;", nativeQuery = true)
    Customer getRetailCustomer();
}
