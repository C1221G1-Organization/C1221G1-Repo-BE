package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
}
