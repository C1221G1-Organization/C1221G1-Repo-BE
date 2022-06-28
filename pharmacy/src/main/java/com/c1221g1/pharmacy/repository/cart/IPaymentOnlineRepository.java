package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentOnlineRepository extends JpaRepository<PaymentOnline, Integer> {
}
