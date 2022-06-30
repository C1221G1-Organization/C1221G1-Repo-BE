package com.c1221g1.pharmacy.service.import_invoice;

import com.c1221g1.pharmacy.dto.import_invoice.MedicineImportDto;

import java.util.List;

public interface IImportInvoiceMedicineService {

    List<MedicineImportDto> findImportMedicineByImportInvoiceId(String importInvoiceId);

    boolean updateMedicineStorage(String importInvoiceId);
}
