package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoiceMedicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;

public interface IImportInvoiceService {
    ImportInvoice saveImportInvoice(ImportInvoice importInvoice);

    Boolean saveImportInvoiceMedicine(ImportInvoiceMedicine importInvoiceMedicine);

    Boolean updateMedicineStorage(Medicine medicine, Integer importInvoiceMedicineImportAmount);
}
