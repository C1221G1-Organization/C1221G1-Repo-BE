package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.InvoiceMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceMedicineRepository extends JpaRepository<InvoiceMedicine,Integer> {
}
