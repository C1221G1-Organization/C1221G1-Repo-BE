package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;

public interface ICartService {
    Cart findCartByCustomerId(String customerId);

    void save(Customer customer);
}
