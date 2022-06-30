package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaymentOnlineService {
    Page<PaymentOnline> findAll(String paymentOnlineIdVal, String customerNameVal, Pageable pageable);

    void save(PaymentOnline paymentOnline);
}
