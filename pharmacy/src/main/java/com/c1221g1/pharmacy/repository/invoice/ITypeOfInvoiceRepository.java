package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeOfInvoiceRepository extends JpaRepository<TypeOfInvoice,Integer> {
}
