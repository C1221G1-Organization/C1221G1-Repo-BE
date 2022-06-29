package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import com.c1221g1.pharmacy.repository.import_invoice.ISupplierRepository;
import com.c1221g1.pharmacy.service.import_invoice.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    ISupplierRepository iSupplierRepository;


    @Override
    public void save(Supplier supplier) {


    }

    @Override
    public Supplier findById(String id) {
        return null;
    }


    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public void removeSupplierById(String id) {
        iSupplierRepository.deleteSupplierById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return null;
    }

    @Override
    public Page<Supplier> findAll(String searchId,
                                  String searchName,
                                  String searchAddress,
                                  String searchPhone,
                                  Pageable pageable) {

        return iSupplierRepository.getAllSupplier("%" + searchId + "%", "%" + searchName + "%", "%" + searchAddress + "%", "%" + searchPhone + "%", pageable);
    }
}
