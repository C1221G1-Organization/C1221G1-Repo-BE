package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
}
