package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.import_invoice.Supplier;
import com.c1221g1.pharmacy.service.import_invoice.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("**")
@RequestMapping("/api/manager-medicine/medicines")
public class SupplierController {


    @Autowired
    ISupplierService iSupplierService;


    @GetMapping("")
    public ResponseEntity<Page<Supplier>> getPageCar(@RequestParam Optional<String> searchId,
                                                     @RequestParam Optional<String> searchName,
                                                     @RequestParam Optional<String> searchAddress,
                                                     @RequestParam Optional<String> searchPhone,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "6") Integer pageSize,
                                                     @RequestParam Optional<String> sort,
                                                     @RequestParam Optional<String> dir
    ) {

        Pageable pageable;
        String sortVal = sort.orElse("");
        String dirVal = dir.orElse("");

        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if (dirVal.equals("asc")) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }

        String valueSupplierId = searchId.orElse("");
        String valueName = searchName.orElse("");
        String valueAddress = searchAddress.orElse("");
        String valuePhone = searchPhone.orElse("");

        Page<Supplier> supplierPage = iSupplierService.findAll(valueSupplierId, valueName, valueAddress, valuePhone, pageable);
        if (!supplierPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierPage, HttpStatus.OK);
    }


    @PatchMapping("/delete-supplier/{supplier_id}")
    public ResponseEntity<Supplier> deleteCar(@PathVariable("supplier_id") String id) {
        try {
            this.iSupplierService.removeSupplierById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
