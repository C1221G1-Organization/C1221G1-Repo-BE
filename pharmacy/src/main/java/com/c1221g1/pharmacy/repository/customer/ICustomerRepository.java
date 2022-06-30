package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ICustomerRepository extends JpaRepository<Customer, String> {
    /**
     * Create by TruongNQ
     * Time : 23:56 29/06/2022
     * Function update customer and customer_type
     */
    @Transactional
    @Modifying
    @Query(value = "update customer set customer_name = :customer_name,customer_address = :customer_address,customer_birthday = :customer_birthday" +
            ",customer_gender = :customer_gender,customer_note = :customer_note,customer_phone = :customer_phone,customer_type_id = :customer_type_id" +
            " where customer_id = :customer_id",
    nativeQuery = true)

    void updateCustomer(@Param("customer_name")String customer_name ,
                        @Param("customer_address")String customer_address ,
                        @Param("customer_birthday")String customer_birthday ,
                        @Param("customer_gender")Integer customer_gender ,
                        @Param("customer_note")String customer_note ,
                        @Param("customer_phone")String customer_phone,
                        @Param("customer_type_id")Integer customer_type_id,
                        @Param("customer_id")String customer_id );


    /**
     * Create by TruongNQ
     * Time : 23:58 29/06/2022
     * Function update customer by id
     */
    @Query(value = "select customer_id,customer_name,customer_address,customer_birthday,customer_gender,customer_note,customer_phone," +
            "customer_type_id, flag, customer_username from customer where customer_id = :customerId",
            nativeQuery = true)
    Customer findByCustomerId(@Param("customerId") String customerId);

}
