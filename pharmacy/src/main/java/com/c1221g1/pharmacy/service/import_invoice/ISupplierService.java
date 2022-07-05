package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.dto.import_invoice.ISupplierDto;
import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplierService {


    void save(Supplier supplier);

    Supplier findById(String id);

    void update(Supplier supplier);

    void removeSupplierById(String id);

    Page<Supplier> findAll(String searchId, String searchName, String searchAddress, String searchPhone, Pageable pageable);


    ISupplierDto findByIdDEtail(String id);
}