package com.c1221g1.pharmacy.service.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;

public interface ICustomerService {
    /**
     *     Create by TruongNQ
     *     Time : 15:05 29/06/2022
     *     Function create customer
     */
    Customer save(Customer customer);



    /**
     *     Create by TruongNQ
     *     Time : 18:04 29/06/2022
     *     Function find by customer id
     */
    Customer findByCustomerId(String customerId);


    /**
     * Create by TruongNQ
     * Time : 20:23 29/06/2022
     * Function update customer
     */
    void updateCustomer(Customer customer);
}
