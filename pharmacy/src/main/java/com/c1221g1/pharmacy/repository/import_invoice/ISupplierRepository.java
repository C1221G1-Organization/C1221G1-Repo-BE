package com.c1221g1.pharmacy.repository.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ISupplierRepository extends JpaRepository<Supplier, String> {


    @Query(value = "select supplier_id, flag, note, supplier_address, supplier_email, supplier_name, supplier_phone from supplier where ( supplier_id like :searchId and supplier_name like :searchName and supplier_address like :searchAddress and supplier_phone like :searchPhone ) and `flag` = 1  ",
            countQuery = "select supplier_id, flag, note, supplier_address, supplier_email, supplier_name, supplier_phone from supplier where ( supplier_id like :searchId and supplier_name like :searchName and supplier_address like :searchAddress and supplier_phone like :searchPhone ) and `flag` = 1  ",
            nativeQuery = true)
    Page<Supplier> getAllSupplier(
            @Param("searchId") String searchId,
            @Param("searchName") String searchName,
            @Param("searchAddress") String searchAddress,
            @Param("searchPhone") String searchPhone,
            Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "UPDATE supplier SET flag = 0 WHERE supplier_id = :id", nativeQuery = true)
    void deleteSupplierById(@Param("id") String id);


    @Transactional
    @Modifying
    @Query(value = " insert into supplier (supplier_name, supplier_address,  supplier_phone, supplier_email, note) VALUE (:note, :supplier_address, :supplier_email, :supplier_name, :supplier_phone )",
            nativeQuery = true)
    void saveSupplier(@Param("supplier_name") String supplier_name,
                      @Param("supplier_address") String supplier_address,
                      @Param("supplier_phone") String supplier_phone,
                      @Param("supplier_email") String supplier_email,
                      @Param("note") String note
    );
//
//    @Query(value = "select supplier_id, flag, note, supplier_address, supplier_email, supplier_name, supplier_phone from supplier where supplier_id :supplierId",
//            nativeQuery = true)
//    Supplier findById(@Param("supplierId") String supplierId);
//

}
