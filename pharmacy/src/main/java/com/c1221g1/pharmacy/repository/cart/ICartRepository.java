package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT cart_id, cart_status, date_create, customer_id, discount_id\n" +
            "FROM cart\n" +
            "WHERE customer_id = :customer_id", nativeQuery = true)
    Cart findCartByCustomerId(@Param("customer_id") String customerId);

    @Query(value = "SELECT cart_id, cart_status, date_create, customer_id, discount_id\n" +
            "FROM cart\n" +
            "WHERE customer_id = :customer_id", nativeQuery = true)
    saveCart(Cart cart);
}
