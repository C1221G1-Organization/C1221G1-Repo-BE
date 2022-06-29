package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailRepository extends JpaRepository<CartDetail,Integer> {
}
