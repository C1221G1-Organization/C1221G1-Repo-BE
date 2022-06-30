package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CartDetailDto;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.validation.BindingResult;

public interface ICartService {
    Cart findCartByCustomerId(String customerId);

    Cart save(Cart cart,String customerId);

    void setCartComplete(Integer cartId);

    Integer countItemInCart(String customerId);
}
