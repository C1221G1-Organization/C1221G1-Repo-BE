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
    @Query(value ="select customer_id, customer_address, customer_birthday," +
            "customer_gender, customer_name, customer_note,customer_phone, " +
            "flag, customer_type_id, customer_username " +
            "from customer order by customer.customer_id asc limit 1",
            nativeQuery = true)
    Customer getRetailCustomer();
}
