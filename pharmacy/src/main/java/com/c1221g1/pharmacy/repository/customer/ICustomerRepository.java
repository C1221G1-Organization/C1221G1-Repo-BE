package com.c1221g1.pharmacy.repository.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

/**
 *     Create by TruongNQ
 *     Time : 15:05 29/06/2022
 *     Function create customer
 */
    @Transactional
    @Modifying
    @Query(value = "insert into customer (customer_name,customer_birthday,customer_address,customer_gender\n" +
            ",customer_note,customer_phone) values (?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void saveCustomer( String customerName, String customerBirthday, Integer customerGender,
                      String customerAddress, String customerPhone, String customerNote);

}
