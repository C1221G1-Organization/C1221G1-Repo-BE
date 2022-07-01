package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: Use for insert cusomter object into table customer in database
     */
//    @Query(value="" +
//            "insert into customer(`customer_id`,`customer_address`, `customer_birthday`, `customer_gender`, `customer_name`, `customer_note`, `customer_phone`, `flag`, `customer_type_id`, `customer_username`) " +
//            "values(:id,:address,:dayOfBirth,:gender,:name,:note,:phone,:flag,:customerType,:email)" +
//            "",nativeQuery=true)
//    @Transactional
//    @Modifying
//    void saveCustomer(@Param("id") String id,
//                      @Param("name") String name,
//                      @Param("address") String address,
//                      @Param("dayOfBirth") String dayOfBirth,
//                      @Param("gender") Integer gender,
//                      @Param("phone") String phone,
//                      @Param("note") String note,
//                      @Param("flag") Boolean flag,
//                      @Param("customerType") Integer customerType,
//                      @Param("email") String email);
}
