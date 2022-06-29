package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.cart.ICartRepository;
import com.c1221g1.pharmacy.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public Cart findCartByCustomerId(String customerId) {
        return this.iCartRepository.findCartByCustomerId(customerId);
    }
    @Override
    public void save(Customer customer) {
        Cart cart = new Cart();
        cart.setCartStatus(false);
        cart.setDateCreate(LocalDate.now().toString());
        cart.setCustomer(customer);
        this.iCartRepository.save(cart);
    }
}
