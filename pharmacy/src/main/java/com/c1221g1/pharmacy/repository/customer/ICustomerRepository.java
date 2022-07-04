package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to get and search customer in database
     */

    @Query(value = "SELECT customer_id, customer_address, customer_birthday, customer_gender, customer_name, customer_note, customer_phone, flag, customer_type_id, customer_username " +
            "FROM customer " +
            "WHERE flag = 1 " +
            "AND customer_id LIKE :customerId " +
            "AND customer_type_id LIKE:customerType " +
            "AND customer_name LIKE:customerName " +
            "AND customer_address LIKE:customerAddress " +
            "AND customer_phone LIKE:customerPhone"
            ,countQuery = "SELECT customer_id, customer_address, customer_birthday, customer_gender, customer_name, customer_note, customer_phone, flag, customer_type_id, customer_username " +
            "FROM customer " +
            "WHERE flag = 1 " +
            "AND customer_id LIKE :customerId " +
            "AND customer_type_id LIKE:customerType " +
            "AND customer_name LIKE:customerName " +
            "AND customer_address LIKE:customerAddress " +
            "AND customer_phone LIKE:customerPhone", nativeQuery = true)
    Page<Customer> getAllSearchAndSortCustomer(
            @Param("customerId") String customerId,
            @Param("customerType") String customerType,
            @Param("customerName") String customerName,
            @Param("customerAddress") String customerAddress,
            @Param("customerPhone") String customerPhone,
            Pageable pageable);


    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to update flag equal false table customer in database
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE customer SET flag = 0 WHERE customer_id= :id", nativeQuery = true)
    void deleteCustomer(@Param("id") String id);

    /**
     * create by TinBQ
     * time: 30/06/2022
     * This method to find id customer in database
     */

    @Query(value = "SELECT customer_id, customer_address, customer_birthday, customer_gender, customer_name, customer_note, customer_phone, flag, customer_type_id, customer_username " +
            "FROM customer WHERE customer_id = :id", nativeQuery = true)
    Optional<Customer> findByCustomerIdOptional(String id);

    /**
     * create by TruongNQ
     * time: 30/06/2022
     * This method to find id customer in database
     */

    @Query(value = "select customer_id,customer_name,customer_address,customer_birthday,customer_gender,customer_note,customer_phone," +
            "customer_type_id, flag, customer_username from customer where customer_id = :customerId",
            nativeQuery = true)
    Customer findByCustomerId(@Param("customerId") String customerId);

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
    void updateCustomer(@Param("customer_name") String customer_name,
                        @Param("customer_address") String customer_address,
                        @Param("customer_birthday") String customer_birthday,
                        @Param("customer_gender") Integer customer_gender,
                        @Param("customer_note") String customer_note,
                        @Param("customer_phone") String customer_phone,
                        @Param("customer_type_id") Integer customer_type_id,
                        @Param("customer_id") String customer_id);
}
