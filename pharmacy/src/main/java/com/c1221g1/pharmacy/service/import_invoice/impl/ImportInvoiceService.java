package com.c1221g1.pharmacy.service.import_invoice.impl;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.repository.import_invoice.IImportInvoiceRepository;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceMedicineService;
import com.c1221g1.pharmacy.service.import_invoice.IImportInvoiceService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportInvoiceService implements IImportInvoiceService {
    @Autowired
    private IImportInvoiceRepository iImportInvoiceRepository;
    @Autowired
    private IImportInvoiceMedicineService importInvoiceMedicineService;
    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: save ImportInvoiceMedicine
     *
     * @param importInvoice
     * @return ImportInvoice
     */
    @Override
    public ImportInvoice saveImportInvoice(ImportInvoice importInvoice) {
        return this.iImportInvoiceRepository.save(importInvoice);
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: save importInvoiceMedicine
     *
     * @param importInvoiceMedicine
     * @return true;
     * note: return true, for validate after.
     */
    @Override
    public Boolean saveImportInvoiceMedicine(ImportInvoiceMedicine importInvoiceMedicine) {
        this.importInvoiceMedicineService.saveImportInvoiceMedicine(importInvoiceMedicine);
        return true;
    }

    /**
     * Created by: TrungTVH
     * Date created: 30/6/2022
     * function: update MedicineStorage
     *
     * @param medicine
     * @param importInvoiceMedicineImportAmount
     * @return true if update success
     * false if update fail,
     * manipulation = 1 -> import.
     */
    @Override
    public Boolean updateMedicineStorage(Medicine medicine, Integer importInvoiceMedicineImportAmount) {
        String medicineId = medicine.getMedicineId();
        Long quantity = Long.valueOf(importInvoiceMedicineImportAmount);
        return this.iMedicineStorageService.changeMedicineQuantity(medicineId, quantity, 1);
    }
}
