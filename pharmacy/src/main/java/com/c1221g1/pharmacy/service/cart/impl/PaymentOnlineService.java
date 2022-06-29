package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.repository.cart.IPaymentOnlineRepository;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentOnlineService implements IPaymentOnlineService {
    @Autowired
    private IPaymentOnlineRepository iPaymentOnlineRepository;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding All payment online object in database with payment id and customer name or just customer name
     * @param paymentOnlineIdVal
     * @param customerNameVal
     * @param pageable
     * @return
     */
    @Override
    public Page<PaymentOnline> findAll(String paymentOnlineIdVal, String customerNameVal, Pageable pageable) {
        if (!paymentOnlineIdVal.equals("")) {
            return this.iPaymentOnlineRepository.findPaymentOnlineByIdAndCustomerName(paymentOnlineIdVal, customerNameVal, pageable);
        } else {
            return this.iPaymentOnlineRepository.findAllPaymentOnlineByCustomerName(customerNameVal, pageable);
        }
    }
}
